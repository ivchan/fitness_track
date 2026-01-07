package homelab.ftrack.util;

public interface KeyValueUtility {
  String getValue(String key) throws Exception;

  void setValue(String key, String value) throws Exception;

  void removeValue(String key) throws Exception;
}
