package homelab.ftrack.exception;

public class EntityNotFoundException extends FtCustomException {
  public EntityNotFoundException(String errorMessage, Throwable err) {
    super(errorMessage);
  }

  public EntityNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}
