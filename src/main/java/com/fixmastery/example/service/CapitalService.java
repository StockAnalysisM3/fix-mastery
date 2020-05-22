package com.fixmastery.example.service;

import com.fixmastery.example.model.Capital;
import com.fixmastery.example.dao.CapitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CapitalService {

    @Autowired
    private CapitalRepository repo;

    public Capital saveOrUpdateCapital(Capital capital) {
        return repo.save(capital);
    }

    public Iterable<Capital> getAllCapitals() {
        return repo.findAll();
    }

    public Optional<Capital> getCapitalByState(String state) {
        return repo.findById(state);
    }

    public Iterable<Capital> getCapitalWithPopulationLimit(long limit) {
        return repo.findAll(isWithinPopulationLimit(limit));
    }

        private Specification<Capital> isWithinPopulationLimit(long limit) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("population"), limit);
        }

    public Iterable<Capital> getCapitalWithAreaLimit(double limit) {
        return repo.findAll(isWithinAreaLimit(limit));
    }

        private Specification<Capital> isWithinAreaLimit(double limit) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("squareMileage"), limit);
        }

    public long loadFromText() throws Exception {
        String fileName = "MoreStateCapitals.txt";
        long count = 0;
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            while(scanner.hasNextLine()) {
                Capital capital = getCapitalFromTextLine(scanner.nextLine());
                saveOrUpdateCapital(capital);
                count++;
            }

            return count;

        } catch (Exception ex) {
            throw new Exception("Failed to load from " + fileName);
        }
    }

        private Capital getCapitalFromTextLine(String line) throws Exception {

            // Alabama::Montgomery::205764::155.4
            try {
                String[] parsedLine = line.split("::");
                String stateName = parsedLine[0];
                String capitalName = parsedLine[1];
                long population = Long.parseLong(parsedLine[2]);
                double squareMileage = Double.parseDouble(parsedLine[3]);

                return new Capital(stateName, capitalName, population, squareMileage);

            } catch (Exception ex) {
                throw new Exception("Invalid figures");
            }
        }


}
