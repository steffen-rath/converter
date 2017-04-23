package de.rath.steffen.converter;

public class BaseConverter<IN extends BaseFromClass, OUT extends BaseToClass> implements Converter<IN, OUT> {

    @Override
    public OUT convert( IN input ) {
        if( input == null ) {
            return null;
        }
        BaseToClass output = new BaseToClass();
        OUT castOutput = castToOutputType( output );
        populateOutput( input, castOutput );
        return castOutput;
    }

    protected void populateOutput( IN input, OUT output ) {
        output.setToString( input.getFromString() );
    }

    @SuppressWarnings("unchecked")
    protected OUT castToOutputType( BaseToClass output ) {
        return (OUT) output;
    }

}
