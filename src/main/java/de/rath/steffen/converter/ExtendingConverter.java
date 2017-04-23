package de.rath.steffen.converter;

public class ExtendingConverter<IN extends ExtendingFromClass, OUT extends ExtendingToClass>
        extends BaseConverter<IN, OUT> {

    @Override
    public OUT apply(IN input) {
        if (input == null) {
            return null;
        }
        ExtendingToClass output = new ExtendingToClass();
        OUT castOutput = castToOutputType(output);
        populateOutput(input, castOutput);
        return castOutput;
    }

    @Override
    protected void populateOutput(IN input, OUT output) {
        super.populateOutput(input, output);
        output.setAnotherToString(input.getAnotherFromString());
    }

}
