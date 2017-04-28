package de.rath.steffen.converter;

public class BaseConverter<IN extends BaseFromClass, OUT extends BaseToClass>
        extends Converter<IN, OUT> {

    @Override
    protected void populateOutput(IN input, OUT output) {
        output.setToString(input.getFromString());
    }

    @SuppressWarnings("unchecked")
    @Override
    protected OUT instantiateOutput() {
        return (OUT) new BaseToClass();
    }

}
