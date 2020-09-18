public class SecretExample {
    public static void main(String[] args) {
        ...
        HttpGet get = new HttpGet("http://localhost:${daprPort}/v1.0/secret/mystore/mysecret");
        HttpResponse resp = client.execute(get);
        String secret = resp.readEntity(StringEntity.class).getContent();
        ...
    }
}
