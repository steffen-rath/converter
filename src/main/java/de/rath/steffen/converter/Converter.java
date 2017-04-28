package de.rath.steffen.converter;

import java.util.function.Function;

public abstract class Converter<T1, T2> implements Function<T1, T2> {

    @Override
    public T2 apply(T1 input) {
        if (input == null) {
            return null;
        }
        T2 output = instantiateOutput();
        populateOutput(input, output);
        return output;
    }

    protected abstract T2 instantiateOutput();

    protected abstract void populateOutput(T1 input, T2 output);

}
