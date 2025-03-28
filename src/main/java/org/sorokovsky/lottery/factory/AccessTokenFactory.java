package org.sorokovsky.lottery.factory;

import org.sorokovsky.lottery.contract.Token;

import java.util.function.Function;

public interface AccessTokenFactory extends Function<Token, Token> {
}
