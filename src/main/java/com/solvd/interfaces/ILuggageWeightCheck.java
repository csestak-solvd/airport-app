package com.solvd.interfaces;

import com.solvd.exceptions.BagOverweightException;

public interface ILuggageWeightCheck {

    void weightCheck() throws BagOverweightException;
}
