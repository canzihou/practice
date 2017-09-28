package 单词计数MapReduce版本;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WordCount {
    public static class Map {
        public void map(String key, String value, OutputCollector<String, Integer> output) {
            String[] result = value.split(" ");
            for(int i = 0;i<result.length;i++){
                output.collect(result[i] , 1);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            int count = 0;
            while(values.hasNext()){
                count += values.next();
            }
            output.collect(key , count);
        }
    }
}
