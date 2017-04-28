package de.rath.steffen.converter;

public class ConverterFactory {

    BaseConverter<BaseFromClass, BaseToClass> getConverter(
            BaseFromClass input) {
        return new BaseConverter<>();
    }

    ExtendingConverter<ExtendingFromClass, ExtendingToClass> getConverter(
            ExtendingFromClass input) {
        return new ExtendingConverter<>();
    }

}
