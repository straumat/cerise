package com.oakinvest.cerise.service;

import com.oakinvest.cerise.dto.CurrencyPairInformationParameters;
import com.oakinvest.cerise.dto.CurrencyPairInformationResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Mocked currency-pair information service.
 *
 * @author straumat
 */
@Service
public class MockedCurrencyPairInformationService implements CurrencyPairInformationService {

    /**
     * The last parameter received by the service.
     */
    private CurrencyPairInformationParameters lastUsedParameter;

    @Override
    @SuppressWarnings("magicnumber")
    public final List<CurrencyPairInformationResult> getCurrencyPairInformation(final CurrencyPairInformationParameters parameters) {
        lastUsedParameter = parameters;
        List<CurrencyPairInformationResult> results = new LinkedList<>();

        // First result.
        CurrencyPairInformationResult result = new CurrencyPairInformationResult();
        result.setCp("XBTUSD-ver4");
        result.setQuote("USD");
        result.setBase("XBT");
        result.setLocale("en_US");
        result.setDesc("Smoothed averages");
        result.setLongDesc("USD price quotes as compared to Bitcoin value\\n\\nRecommended for casual usage");
        result.setSymbol(Arrays.asList(Arrays.asList("-$", "$"), null));
        result.setDigits("Arabic");
        // TODO Should be array of different types ?
        result.setGrouping(Arrays.asList("3", ",", "0"));
        result.setFractionSeparator(".");
        List<Integer> fractionDigits = new ArrayList<>();
        fractionDigits.add(0);
        fractionDigits.add(2);
        fractionDigits.add(2);
        result.setFractionDigits(fractionDigits);
        result.setMinPoll(300);
        result.setLongPoll(true);
        result.setHistory(1457231416L);
        result.setArchive(14572314161L);
        results.add(result);

        // Second result.
        result = new CurrencyPairInformationResult();
        result.setCp("2");
        result.setQuote("USD");
        result.setBase("XBT");
        result.setLocale("en_US");
        result.setDesc("Updated per-trade");
        result.setLongDesc("Maximum precision USD price quotes as compared to Bitcoin value");
        result.setSymbol(Arrays.asList(Arrays.asList("-$", "$"), null));
        result.setDigits("Arabic");
        // TODO Should be array of different types ?
        result.setGrouping(Arrays.asList("3", ",", "0"));
        result.setFractionSeparator(".");
        result.setFractionDigits(fractionDigits);
        result.setMinPoll(3600);
        result.setLongPoll(false);
        result.setHistory(1467458333L);
        result.setArchive(14674583332L);
        results.add(result);

        return results;
    }

    /**
     * Getter of lastUsedParameter.
     *
     * @return lastUsedParameter
     */
    public final CurrencyPairInformationParameters getLastUsedParameter() {
        return lastUsedParameter;
    }
}
