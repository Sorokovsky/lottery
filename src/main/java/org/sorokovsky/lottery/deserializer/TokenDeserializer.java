package org.sorokovsky.lottery.deserializer;

import org.sorokovsky.lottery.contract.Token;

import java.util.function.Function;

public interface TokenDeserializer extends Function<String, Token> {
}
