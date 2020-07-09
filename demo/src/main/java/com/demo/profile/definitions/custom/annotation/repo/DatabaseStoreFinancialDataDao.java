package com.demo.profile.definitions.custom.annotation.repo;

import com.demo.profile.definitions.custom.annotation.annotations.DatabaseProfile;
import com.demo.profile.definitions.custom.annotation.beans.FinancialMonthSummary;
import com.demo.profile.definitions.custom.annotation.beans.FinancialQuarterSummary;
import com.demo.profile.definitions.custom.annotation.beans.FinancialYearSummary;
import org.springframework.stereotype.Component;

@Component
@DatabaseProfile
class DatabaseStoreFinancialDataDao implements FinancialDataDao {
    @Override
    public FinancialYearSummary findFinancialYearSummary(int year) {
        System.out.println("Database Dao => findFinancialYearSummary");
        return new FinancialYearSummary();
    }

    @Override
    public FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter) {
        System.out.println("Database Dao => findFinancialQuarterSummary");
        return new FinancialQuarterSummary();
    }

    @Override
    public FinancialMonthSummary findFinancialMonthSummary(int year, int month) {
        System.out.println("Database Dao => findFinancialMonthSummary");
        return new FinancialMonthSummary();
    }
}
