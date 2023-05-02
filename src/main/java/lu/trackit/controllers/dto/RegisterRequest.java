package lu.trackit.controllers.dto;

public record RegisterRequest(String firstname, String lastname, String email, String password) {
}
