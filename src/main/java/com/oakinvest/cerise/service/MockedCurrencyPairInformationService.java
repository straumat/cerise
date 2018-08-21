package com.oakinvest.cerise.service;

import com.oakinvest.cerise.dto.CurrencyPairInformationParameters;
import com.oakinvest.cerise.dto.CurrencyPairInformationResult;
import com.oakinvest.cerise.dto.Grouping;
import com.oakinvest.cerise.util.generic.CeriseService;
import org.apache.commons.lang3.StringUtils;
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
public class MockedCurrencyPairInformationService extends CeriseService implements CurrencyPairInformationService {

    /**
     * The last parameter received by the service.
     */
    private CurrencyPairInformationParameters lastReceivedParameter;

    @Override
    @SuppressWarnings("magicnumber")
    public final List<CurrencyPairInformationResult> getCurrencyPairInformation(final CurrencyPairInformationParameters parameters) {
        lastReceivedParameter = parameters;
        List<CurrencyPairInformationResult> results = new LinkedList<>();
        CurrencyPairInformationResult result;

        // Test for long CP maximum size.
        if (parameters.getCp().size() > 0 && "TEST_LONG_CP".equals(parameters.getCp().get(0))) {
            result = new CurrencyPairInformationResult();
            result.setCp(StringUtils.repeat("*", 256));
            result.setQuote("USD");
            result.setBase("XBT");
            result.setLocale("en_US");
            result.setDesc("Smoothed averages");
            result.setLongDesc("USD price quotes as compared to Bitcoin value\\n\\nRecommended for casual usage");
            result.setSymbol(Arrays.asList(Arrays.asList("-$", "$"), null));
            result.setDigits("Arabic");
            result.setGrouping(new Grouping(3, ",", 0));
            result.setFractionSeparator(".");
            List<Integer> fractionDigits = new ArrayList<>();
            fractionDigits.add(0);
            fractionDigits.add(2);
            fractionDigits.add(2);
            result.setFractionDigits(fractionDigits);
            result.setMinPoll(300);
            result.setLongPoll(true);
            result.setHistory(1457231416D);
            result.setArchive(14572314161D);
            results.add(result);
            results.add(result);
        }

        // First result.
        result = new CurrencyPairInformationResult();
        result.setCp("XBTUSD-ver4");
        result.setQuote("USD");
        result.setBase("XBT");
        result.setLocale("en_US");
        result.setDesc("Smoothed averages");
        result.setLongDesc("USD price quotes as compared to Bitcoin value\\n\\nRecommended for casual usage");
        result.setSymbol(Arrays.asList(Arrays.asList("-$", "$"), null));
        result.setDigits("Arabic");
        result.setGrouping(new Grouping(3, ",", 0));
        result.setFractionSeparator(".");
        List<Integer> fractionDigits = new ArrayList<>();
        fractionDigits.add(0);
        fractionDigits.add(2);
        fractionDigits.add(2);
        result.setFractionDigits(fractionDigits);
        result.setMinPoll(300);
        result.setLongPoll(true);
        result.setHistory(1457231416D);
        result.setArchive(145723141D);
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
        result.setGrouping(new Grouping(3, ",", 0));
        result.setFractionSeparator(".");
        result.setFractionDigits(fractionDigits);
        result.setMinPoll(3600);
        result.setLongPoll(false);
        result.setHistory(1467458333.1225);
        result.setArchive(146745833.1225);
        results.add(result);

        return results;
    }

    /**
     * Getter of lastReceivedParameter.
     *
     * @return lastReceivedParameter
     */
    public final CurrencyPairInformationParameters getLastReceivedParameter() {
        return lastReceivedParameter;
    }

}
