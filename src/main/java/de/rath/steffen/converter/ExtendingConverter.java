package de.rath.steffen.converter;

public class ExtendingConverter<IN extends ExtendingFromClass, OUT extends ExtendingToClass>
        extends BaseConverter<IN, OUT> {

    @SuppressWarnings("unchecked")
    @Override
    protected OUT instantiateOutput() {
        return (OUT) new ExtendingToClass();
    }

    @Override
    protected void populateOutput(IN input, OUT output) {
        super.populateOutput(input, output);
        output.setAnotherToString(input.getAnotherFromString());
    }

}
