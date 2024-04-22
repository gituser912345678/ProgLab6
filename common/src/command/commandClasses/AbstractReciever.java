package command.commandClasses;

import network.Request;
import network.Respons;

public interface AbstractReciever {
    abstract Respons info();

    abstract Respons clear();

    abstract Respons executeScript(Request request);

    abstract Respons filterByHairColor(Request request);

    abstract Respons help();

    abstract Respons insert(Request request);

    abstract Respons removeGreater(Request request);

    abstract Respons removeGreaterKey(Request request);

    abstract Respons removeKey(Request request);

    abstract Respons removeLower(Request request);

    abstract Respons show();

    abstract Respons updateId(Request request);
}
