package ru.nsu.ccfit.chernovskaya.zoo.util;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Map;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Individual;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.Staff;

@UtilityClass
public class SpecPageSortUtil {

    public static Pageable generatePageable(
            int page, int pageSize, @NonNull Sort sort) {
        return PageRequest.of(page, pageSize).withSort(sort);
    }

    public static @NonNull Sort generateSort(
            List<String> sorts, @NonNull List<String> availableSortFields) {
        if (sorts == null) {
            sorts = List.of();
        }
        return sorts.stream()
                .filter(
                        s -> StringUtils.equalsAny(s, availableSortFields.toArray(new String[0])))
                .map(s -> s.contains("asc") ? Sort.by(Sort.Direction.ASC, s.replace("asc", ""))
                        : Sort.by(Sort.Direction.DESC, s.replace("desc", "")))
                .reduce(Sort.unsorted(), Sort::and);
    }

    public static Specification<Individual> generateIndividualSpec(Map<String, String> filter) {
        if (filter == null) {
            return (root, query, builder) -> builder.conjunction();
        }
        return (root, query, builder) -> {
            var spec = builder.conjunction();
            if (filter.containsKey("gender")) {
                var concatParts =
                        List.of(
                                builder.concat(root.get("gender"), " "));
                var nameExpr = concatParts.stream().reduce(builder::concat).get();
                spec = builder.and(spec, builder.like(nameExpr, "%" + filter.get("gender") + "%"));
            }
            if (filter.containsKey("isAlive")) {
                var concatParts =
                        List.of(
                                builder.concat(root.get("isAlive"), " "));
                var nameExpr = concatParts.stream().reduce(builder::concat).get();
                spec = builder.and(spec, builder.like(nameExpr, "%" + filter.get("isAlive") + "%"));
            }


            return spec;
        };
    }

    public static Specification<Staff> generateStaffSpec(Map<String, String> filter) {
        if (filter == null) {
            return (root, query, builder) -> builder.conjunction();
        }
        return (root, query, builder) -> {
            var spec = builder.conjunction();
            if (filter.containsKey("gender")) {
                var concatParts =
                        List.of(
                                builder.concat(root.get("gender"), " "));
                var nameExpr = concatParts.stream().reduce(builder::concat).get();
                spec = builder.and(spec, builder.like(nameExpr, "%" + filter.get("gender") + "%"));
            }

            return spec;
        };
    }
}