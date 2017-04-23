package de.rath.steffen.converter;

import java.util.function.Function;

public class ListConverter<IN, OUT> implements Function<IN, OUT> {

    private final Converter<IN, OUT> converter;

    public ListConverter(Converter<IN, OUT> converter) {
        this.converter = converter;
    }

    @Override
    public OUT apply(IN t) {
        return converter.convert(t);
    }

}
