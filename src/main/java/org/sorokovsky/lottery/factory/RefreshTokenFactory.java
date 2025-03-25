package org.sorokovsky.lottery.factory;

import org.sorokovsky.lottery.contract.Token;
import org.springframework.security.core.Authentication;

import java.util.function.Function;

public interface RefreshTokenFactory extends Function<Authentication, Token> {
}
