package io.victorferreira.auth_api.dtos;

public record UsuarioDto(
        String nome,
        String login,
        String senha
) {
}
