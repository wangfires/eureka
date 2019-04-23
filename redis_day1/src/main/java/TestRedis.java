import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class TestRedis {
    public static void main(String[] args) {
        //创建jedis客户端对象
        Jedis jedis = new Jedis("192.168.31.200",6379);
        //操作redis
//        String id=jedis.set("id","1");
//        id =jedis.get("id");
//        String name=jedis.get("name");
//        System.out.println("id: "+id);
//        System.out.println("name: "+name);
//
//        jedis.mset("start", "niu", "animal", "mouse");
//        String start = jedis.get("start");
//        String animal = jedis.get("animal");
//        System.out.println("start :"+start+"   animal:"+animal);
//        List<String> mget = jedis.mget("id", "name", "start");
//        for (String s : mget) {
//            System.out.println(s);
//        }
//        String set = jedis.getSet("name", "wangwang");
//        String name1 = jedis.get("name");
//        System.out.println(set);
//        System.out.println(name1);
//        System.out.println("-----------------------------------------");
//        jedis.append("name", "sb");
//        String name2 = jedis.get("name");
//        System.out.println(name2);
//        String animal1 = jedis.getrange("animal", 0, 3);
//        System.out.println(animal1);
//        System.out.println("------------测试list------------");
//        jedis.lpush("yyy", "ww", "yy", "ll", "mm");
//        List<String> yyy = jedis.lrange("yyy", 0, -1);
//        for (String s : yyy) {
//            System.out.println(s);
//        }
//        System.out.println("--------------------------");
//
//        jedis.rpush("yyy","aa");
//        List<String> yyy1 = jedis.lrange("yyy", 0, -1);
//        for (String s : yyy1) {
//            System.out.println(s);
//        }
//        System.out.println("--------------------------");
//        jedis.lpop("yyy");
//        List<String> yyy2 = jedis.lrange("yyy", 0, -1);
//        for (String s : yyy2) {
//            System.out.println(s);
//        }
//        System.out.println("=========================");
//        Long l = jedis.llen("yyy");
//        System.out.println(l);
//        jedis.lrem("yyy",4,"aa");
//        System.out.println(jedis.lrange("yyy",0,-1));
//        System.out.println("=======================================");
//        jedis.sadd("www","aa","bb","cc");
//        Set<String> www = jedis.smembers("www");
//        System.out.println(www);
//        System.out.println(jedis.scard("www"));
//
//        System.out.println(jedis.spop("www"));
//        System.out.println(jedis.srem("www","aa"));
//        System.out.println(jedis.scard("www"));
//        System.out.println(jedis.sismember("www","aa"));
//        Map<String,Double>map = new HashMap<String,Double>();
//        map.put("aa",10.0);
//        map.put("bb",20.0);
//        jedis.zadd("q",map);
//        System.out.println(jedis.zcard("q"));
//        System.out.println(jedis.zrange("q",0,-1));
//        System.out.println(jedis.zrangeByScore("q",0,15));
//        System.out.println(jedis.zrank("q","aa"));
//        System.out.println(jedis.zscore("q","bb"));
//        System.out.println(jedis.zincrby("q",100,"aa"));
//        System.out.println(jedis.zscore("q","aa"));
        HashMap<String, String> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        jedis.hmset("w",map);
        System.out.println(jedis.hget("w","a"));
        System.out.println(jedis.hgetAll("w"));
        jedis.hdel("w","a");
        System.out.println(jedis.hexists("w","a"));
        System.out.println(jedis.hvals("w"));

    }
}
