package com.cedrus.practice.todo.Spring_Boot_Todos;

import com.cedrus.practice.todo.Spring_Boot_Todos.controller.ToDoController;
import com.cedrus.practice.todo.Spring_Boot_Todos.model.ToDoItem;
import com.cedrus.practice.todo.Spring_Boot_Todos.repository.ToDoRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

public class ToDoControllerTests {

    @InjectMocks
    private ToDoController toDoController;

    @Mock
    private ToDoRepo toDoRepo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testToDoGet() {
        List<ToDoItem> results = toDoRepo.findAll();
        assertThat(results.size(), is(greaterThanOrEqualTo(0)));
    }

    @Test
    public void testToDoPost() {
        ToDoItem test = new ToDoItem(1, "test");
        toDoRepo.save(test);

        ToDoItem result = toDoRepo.getOne(1);
        assertThat(result.getId(), is(1));
    }

}
