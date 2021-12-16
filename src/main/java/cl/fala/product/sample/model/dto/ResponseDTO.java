package cl.fala.product.sample.model.dto;

/**
 * @author: David Toro Salamanca.
 * Description: Wrapp para respuesta custom.
 * */
public class ResponseDTO {

    private String code;
    private String message;

    public ResponseDTO() {
    }

    public ResponseDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
