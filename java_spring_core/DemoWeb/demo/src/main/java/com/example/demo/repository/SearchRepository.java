package com.example.demo.repository;

import com.example.demo.dto.response.PageResponse;
import com.example.demo.model.User;
import com.example.demo.repository.criteria.SearchCriteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
@Slf4j
public class SearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public PageResponse<?> findBySearch(int pageNo, int pageSize, String search) {

        StringBuilder stringBuilder = new StringBuilder("select new com.example.demo.dto.response.UserDetailResponse(firstName, lastName, firstName, firstName) from User u where 1=1");
        if (StringUtils.hasLength(search)) {
            stringBuilder.append(" and u.firstName like lower(:firstName)");
            stringBuilder.append(" or u.lastName like lower(:lastName)");
            stringBuilder.append(" or u.username like lower(:username)");
        }

        Query selectQuery = entityManager.createQuery(stringBuilder.toString());

        selectQuery.setFirstResult(pageNo);
        selectQuery.setMaxResults(pageSize);
        selectQuery.setParameter("firstName", "%" + search + "%");
        selectQuery.setParameter("lastName", "%" + search + "%");
        selectQuery.setParameter("username", "%" + search + "%");

        List<User> users = selectQuery.getResultList();

        System.out.println(users.size());

        StringBuilder stringBuilderCount = new StringBuilder("select count(*) from User u");
        if (StringUtils.hasLength(search)) {
            stringBuilderCount.append(" where lower(u.firstName) like lower(:firstName)");
            stringBuilderCount.append(" or lower(u.lastName) like lower(:lastName)");
            stringBuilderCount.append(" or lower(u.username) like lower(:username)");
        }

        Query countQuery = entityManager.createQuery(stringBuilderCount.toString());
        countQuery.setParameter("firstName", "%" + search + "%");
        countQuery.setParameter("lastName", "%" + search + "%");
        countQuery.setParameter("username", "%" + search + "%");

        Long countResult = (Long) countQuery.getSingleResult();

        Page<?> page = new PageImpl<User>(users, PageRequest.of(pageNo, pageSize), countResult);

        return PageResponse.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalPage(page.getTotalPages())
                .list(page.stream().toList())
                .build();
    }

    public PageResponse<?> findByCriteria(int pageNo, int pageSize, String... search) {

        List<SearchCriteria> criteriaList = new ArrayList<>();

        // get user
        if (search != null) {
            for (String sear : search) {
                Pattern pattern = Pattern.compile("(\\w+?)(:|>|<)(.*)");
                Matcher matcher = pattern.matcher(sear);

                if (matcher.find()) {
                    criteriaList.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
                }
            }
        }

        // count record num

        return PageResponse.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalPage(0)
                .list(null)
                .build();
    }
}
