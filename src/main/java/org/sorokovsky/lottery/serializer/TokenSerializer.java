package org.sorokovsky.lottery.serializer;

import org.sorokovsky.lottery.contract.Token;

import java.util.function.Function;

public interface TokenSerializer extends Function<Token, String> {

}
