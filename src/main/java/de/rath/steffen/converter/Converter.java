package de.rath.steffen.converter;

public interface Converter<IN, OUT> {

    OUT convert( IN input );
}
