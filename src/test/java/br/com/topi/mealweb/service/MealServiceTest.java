package br.com.topi.mealweb.service;

import br.com.topi.mealweb.dto.MealDTO;
import br.com.topi.mealweb.dto.MealDTOList;
import br.com.topi.mealweb.utils.Letter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class MealServiceTest {

    @Mock
    private MealDataService dataService;

    private MealService mealService;

    @BeforeEach
    public void beforeTest(){
        MockitoAnnotations.openMocks(this);
        mealService = new MealService(dataService);
    }

    @Test
    @DisplayName("Passando null em ambos os paramentros deve ter retorno null")
    public void entradaInvalidaFailTest(){
        mealNameMock();

        assertNull(mealService.findByParams(null,null));
    }

    @Test@DisplayName("Passando nome valido deve retornar lista de meals")
    public void nomeValidoSucessTest(){
        mealNameMock();

        //Given
        String name = "arroz";

        //When
        List<MealDTO> meals = mealService.findByParams(null, name);

        //then
        assertNotNull(meals);
        meals.forEach(m -> assertTrue(m.getName().contains(name)));
    }

    @Test
    @DisplayName("Passando uma inicial valida deve fornecer uma lista de meals")
    public void inicialValidaSucessTest(){
        initialLetterMock();

        //given
        String initial = Letter.C.name();

        //when
        List<MealDTO> meals = mealService.findByParams(initial,null);

        //then
        assertNotNull(meals);
        meals.forEach(m -> assertTrue(m.getName().startsWith(initial,0)));
    }

    @Test
    @DisplayName("Passando um nome e inicial valida deve ignorar a incial e retornar uma lista de meal com nomes validos")
    public void nameAndInitialValidSucessTest(){
        initialLetterMock();
        mealNameMock();

        //given
        String initial = Letter.C.name();
        String name = "arroz";

        //when
        List<MealDTO> meals = mealService.findByParams(initial,name);

        //then
        assertNotNull(meals);
        meals.forEach(m -> assertTrue(m.getName().contains(name)));

    }

    private void initialLetterMock(){

        List<MealDTO> mealsWithCInitial = new ArrayList<>();
        MealDTO meal = new MealDTO(1L,"Cachorro quente", "Pão, molho e vina");
        mealsWithCInitial.add(meal);

        MealDTO meal2 = new MealDTO(2L,"Camarão frito", "descasque o camarão e frite no oleo quente");
        mealsWithCInitial.add(meal2);

        MealDTOList meals = new MealDTOList();
        meals.setMeals(mealsWithCInitial);

        when(dataService.findMealsByInitial(Letter.C.name())).thenReturn(meals);
    }

    private void mealNameMock(){
        List<MealDTO> mealsWithArrozName = new ArrayList<>();
        MealDTO arroz1 = new MealDTO(3L, "Arroz branco","Coloque o arroz na agua quente");
        MealDTO arroz2 = new MealDTO(4L, "Arroz japones", "Coloque o arroz na agua quente");

        MealDTOList meals2 = new MealDTOList();
        meals2.setMeals(mealsWithArrozName);

        when(dataService.findMealsByName("arroz")).thenReturn(meals2);
    }

}
