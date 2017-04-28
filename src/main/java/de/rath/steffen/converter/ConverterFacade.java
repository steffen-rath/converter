package de.rath.steffen.converter;

import java.util.List;

public class ConverterFacade {

    public BaseToClass convert(BaseFromClass from) {
        if (from instanceof ExtendingFromClass) {
            return new ExtendingConverter<>().apply((ExtendingFromClass) from);
        }
        return new BaseConverter<>().apply(from);
    }

    public void convertBaseFromClassList(List<BaseFromClass> input,
            List<BaseToClass> output) {
        for (BaseFromClass entry : input) {
            output.add(convert(entry));
        }
    }

}
