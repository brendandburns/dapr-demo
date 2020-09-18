public class StorageExample {
    public static void main(String[] args) {
        ...
        String json = GSON.toJson(object);
        HttpPost post = new HttpPost("http://localhost:8080/v1.0/state/myStore");
        httpPost.setEntity(new StringEntity(json));
        client.execute(post);
        ...
    }
}