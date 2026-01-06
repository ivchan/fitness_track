package homelab.ftrack.util;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import io.etcd.jetcd.ByteSequence;
import io.etcd.jetcd.Client;
import io.etcd.jetcd.KV;
import io.etcd.jetcd.kv.GetResponse;

@Service
public class EtcdKeyValUtil implements KeyValUtil {
  private final Client client;

  public EtcdKeyValUtil(Client client) {
    this.client = client;
  }

  @Override
  public String getValue(String key) throws Exception {
    KV kvClient = client.getKVClient();
    ByteSequence keyBS = ByteSequence.from(key, StandardCharsets.UTF_8);
    CompletableFuture<GetResponse> getFuture = kvClient.get(keyBS);
    GetResponse response = getFuture.get();
    if (response.getKvs().isEmpty()) {
      return null;
    }
    return response.getKvs().get(0).getValue().toString(StandardCharsets.UTF_8);
  }

  @Override
  public void setValue(String key, String value) throws Exception {
    KV kvClient = client.getKVClient();
    ByteSequence keyBS = ByteSequence.from(key, StandardCharsets.UTF_8);
    ByteSequence valueBS = ByteSequence.from(value, StandardCharsets.UTF_8);
    kvClient.put(keyBS, valueBS).get();
  }

}
