package homelab.ftrack.util;

public interface KeyValueUtility {
  String getValue(String key) throws Exception;

  void setValue(String key, String value) throws Exception;

  byte[] getImage(String key) throws Exception;

  void setImage(String key, byte[] imageBytes) throws Exception;

  void removeValue(String key) throws Exception;
}
