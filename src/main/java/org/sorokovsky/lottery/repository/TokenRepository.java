package org.sorokovsky.lottery.repository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.sorokovsky.lottery.contract.Token;

public interface TokenRepository {
    void set(Token token, HttpServletResponse response);

    Token get(HttpServletRequest request);

    void remove(HttpServletResponse response);
}
