package interfaces;

import exceptions.BagOverweightException;

public interface ILuggageWeightCheck {
    void weightCheck() throws BagOverweightException;
}
