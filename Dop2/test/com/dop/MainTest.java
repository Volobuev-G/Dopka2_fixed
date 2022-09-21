package com.dop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testScoreCounter() {
        List<Integer> list = List.of(2,4,30);
        Assertions.assertEquals(Main.scoreCounter(list),60);
    }

    @Test
    void testListUpdater() {
        List<Integer> listOld = List.of(1,6,20);
        List<Integer> listUpdated = List.of(3,3,30);
        List<Integer> listFinal = List.of(2,9,50);
        Assertions.assertEquals(Main.listUpdater(listOld,listUpdated),listFinal);
    }
}