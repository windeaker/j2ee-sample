package kafka.sample;

import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/13
 */
public class CustomSerializerSample {

    public static class User {
        int id;
        String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class UserSerializer implements Serializer<User> {

        @Override
        public void configure(Map<String, ?> configs, boolean isKey) {

        }

        @Override
        public byte[] serialize(String topic, User data) {
            if (data == null) {
                return null;
            }
            byte[] id, name;
            try {
                if (data.getName() != null) {
                    name = data.getName().getBytes("UTF-8");
                } else {
                    name = new byte[0];
                }

                id=new byte[0];
                id[0]=Integer.valueOf(data.getId()).byteValue();
                ByteBuffer buffer=ByteBuffer.allocate(4+4+name.length+id.length);
                buffer.putInt(name.length);
                buffer.put(name);
                buffer.putInt(id.length);
                buffer.put(id);
                return buffer.array();

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return new byte[0];
        }

        @Override
        public void close() {

        }
    }
}
