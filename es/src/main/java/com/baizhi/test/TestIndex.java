package com.baizhi.test;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

public class TestIndex {
    @Test
    public void testIndexMapping() throws IOException, ExecutionException, InterruptedException {
        TransportAddress transportAddress = new TransportAddress(InetAddress.getByName("192.168.31.111"), 9300);
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(transportAddress);
        System.out.println("=============创建索引============");
        CreateIndexResponse indexResponse = transportClient.admin().indices().prepareCreate("dangdang").execute().get();
        System.out.println(indexResponse.index());
        System.out.println("=========创建映射指定类型==========");
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject()
                .startObject("properties")
                .startObject("name")
                .field("type", "text")
                .field("analyzer", "ik_max_word")
                .endObject()
                .startObject("age")
                .field("type", "integer")
                .endObject()
                .startObject("sex")
                .field("type", "keyword")
                .endObject()
                .startObject("content")
                .field("type", "text")
                .field("analyzer", "ik_max_word")
                .endObject()
                .endObject()
                .endObject();
        PutMappingRequest putMappingRequest = new PutMappingRequest("dangdang").type("book").source(builder);
        transportClient.admin().indices().putMapping(putMappingRequest).get();
    }
        @Test
        public void testCreate() throws IOException {
            TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.31.111"), 9300));
            XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("name","中国人")
                    .field("age",23)
                    .field("sex","男")
                    .field("content","他是一个中国人,这个中国人怎么样,挺好的").endObject();
            IndexResponse indexResponse = transportClient.prepareIndex("dangdang", "book","1").setSource(xContentBuilder).get();
            System.out.println(indexResponse.status());
        }
        @Test
    public void testUpdate() throws IOException {
            TransportAddress transportAddress = new TransportAddress(InetAddress.getByName("192.168.31.111"), 9300);
            TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(transportAddress);
            XContentBuilder xContentBuilder = XContentFactory.jsonBuilder();
            xContentBuilder.startObject().field("name","小黑是中国人").endObject();
            UpdateResponse updateResponse = transportClient.prepareUpdate("dangdang", "book", "1").setDoc(xContentBuilder).get();
            System.out.println(updateResponse.status());
        }
    @Test
    public void testBulk() throws IOException {
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.31.111"), 9300));

        //添加第一条记录
        IndexRequest request1 = new IndexRequest("dangdang","book","1");
        request1.source(XContentFactory.jsonBuilder().startObject().field("name","中国科技").field("age",23).field("sex","男").field("content","这是个好人").endObject());


        //添加第二条记录
        IndexRequest request2 = new IndexRequest("dangdang","book","2");
        request2.source(XContentFactory.jsonBuilder().startObject().field("name","中国之声").field("age",23).field("sex","男").field("content","这是一个好的声音").endObject());

        //更新记录
        UpdateRequest updateRequest = new UpdateRequest("dangdang","book","1");
        updateRequest.doc(XContentFactory.jsonBuilder().startObject().field("name","中国力量").endObject());

        //删除一条记录
        DeleteRequest deleteRequest = new DeleteRequest("dangdang","book","1");

        BulkResponse bulkItemResponses = transportClient.prepareBulk().add(request1).add(request2).add(updateRequest).add(deleteRequest).get();
        BulkItemResponse[] items = bulkItemResponses.getItems();
        for (BulkItemResponse item : items) {
            System.out.println(item.status());
        }

    }
    @Test
    public void testMatchAllQuery() throws Exception {
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.31.111"), 9300));
        SearchResponse searchResponse = transportClient.prepareSearch("dangdang").setTypes("book").setQuery(QueryBuilders.matchAllQuery()).addSort("age", SortOrder.DESC).get();
        SearchHits hits = searchResponse.getHits();
        System.out.println("符合条件的记录数: "+hits.totalHits);
        for (SearchHit hit : hits) {
            System.out.print("当前索引的分数: "+hit.getScore());
            System.out.print(", 对应结果:=====>"+hit.getSourceAsString());
            System.out.println(", 指定字段结果:"+hit.getSourceAsMap().get("name"));
            System.out.println("=================================================");
        }
    }
    @Test
    public void testPage() throws UnknownHostException {
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.31.111"), 9300));
        SearchResponse searchResponse = transportClient.prepareSearch("dangdang").setTypes("book").setQuery(QueryBuilders.matchAllQuery()).addSort("age", SortOrder.DESC).get();
        SearchHits hits = searchResponse.getHits();
        System.out.println("符合条件的记录数"+hits.totalHits);
        for (SearchHit hit : hits) {
            System.out.println("当前索引的分数"+hit.getScore());
            System.out.println("对应结果=====>"+hit.getSourceAsString());
            System.out.println("指定字段结果=====>"+hit.getSourceAsMap().get("name"));
            System.out.println("========================");

        }
    }
    @Test
    public void testsource() throws UnknownHostException {
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.31.111"), 9300));
        SearchResponse searchResponse = transportClient.prepareSearch("dangdang").setTypes("book").setQuery(QueryBuilders.matchAllQuery()).setFetchSource("*", "age").get();
        SearchHits hits = searchResponse.getHits();
        System.out.println("符合条件的记录数" + hits.totalHits);
        for (SearchHit hit : hits) {
            System.out.println("当前索引的分数" + hit.getScore());
            System.out.println("对应结果=====>" + hit.getSourceAsString());
            System.out.println("指定字段结果=====>" + hit.getSourceAsMap().get("name"));
            System.out.println("========================");

        }
    }




}
