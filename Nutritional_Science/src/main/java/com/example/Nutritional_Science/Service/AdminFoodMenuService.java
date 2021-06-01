package com.example.Nutritional_Science.Service;

import com.example.Nutritional_Science.Entity.FoodMenu;
import com.example.Nutritional_Science.Repository.FoodMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminFoodMenuService {

    @Autowired
    FoodMenuRepository foodMenuRepository;
    List<String> foodTypeList = new ArrayList<>();

    public void start() {
        if(foodMenuRepository.count() == 0){
            fillFoodTypeList();
            fillMonday();
            fillTuesday();
            fillWednesday();
            fillThursday();
            fillFriday();
            fillSaturday();
            fillSunday();
        }
    }

    private void fillFoodTypeList() {
        foodTypeList.add("ЗАВТРАК\n 9-00");
        foodTypeList.add("2-Й ЗАВТРАК\n 11-30\n (через 2-3 часа)");
        foodTypeList.add("ОБЕД\n 14-00\n (через 2-3 часа)");
        foodTypeList.add("ПОЛДНИК\n 16-30\n (через 2-3 часа)");
        foodTypeList.add("УЖИН\n 19-00\n за 3-4 часа до сна)");
        foodTypeList.add("ПЕРЕД СНОМ (по желанию)");
    }

    private void addFoodMenu(String foodType, int numberDayWeek, String name, int quantity, int calories){
        FoodMenu foodMenu = new FoodMenu();
        foodMenu.setFoodType(foodType);
        foodMenu.setNumberDayWeek(numberDayWeek);
        foodMenu.setName(name);
        foodMenu.setQuantity(quantity);
        foodMenu.setCalories(calories);
        foodMenuRepository.save(foodMenu);
    }

    private void fillMonday(){
        final int numberDayWeek = 0;
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Яйцо отварное (2 шт)",100, 170);
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Салат из свежих овощей и зелени с оливковым маслом",150, 111);
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Сыр Фета",50,130);
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Хлеб цельнозерновой, ржаной или чёрный подсушенный  с сыром",40, 150);
        addFoodMenu(foodTypeList.get(1),numberDayWeek,"Любые свежие фрукты (кроме банана, винограда, инжира, хурмы)", 170, 300);
        addFoodMenu(foodTypeList.get(1),numberDayWeek,"Орехи любые, кроме арахиса, без соли (10 шт)", 80, 250);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Рыба жирных сортов (сёмга, форель, тунец и др.) (на пару, запечённая)", 150, 330);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Рис (бурый)", 100, 110);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Хлеб цельнозерновой, ржаной или чёрный подсушенный  с сыром", 30, 110);
        addFoodMenu(foodTypeList.get(3),numberDayWeek,"Кефир, йогурт натуральный, без добавок-до 2,5% (без фруктов, ягод, шоколада). Можно добавить 1-2 чайн. ложки семян чиа", 250, 137);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Куриная грудка, индейка, кролик ", 200, 360);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Овощи любые (кроме картофеля: кабачки, цветная капуста, спаржа, шпинат, фасоль сручковая и другие-на пару)+можно заправить лимонным соком", 100, 65);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Хлеб цельнозерновой, ржаной или чёрный подсушенный ", 40, 150);
        addFoodMenu(foodTypeList.get(5),numberDayWeek,"Настой плодов шиповника, травяной чай", 200, 110);
    }
    private void fillTuesday(){
        final int numberDayWeek = 1;
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Каша любая на воде 1:1 с мёдом",150, 225);
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Хлеб цельнозерновой, ржаной или чёрный подсушенный  с сыром",40,150);
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Напиток без сахара",200, 15);
        addFoodMenu(foodTypeList.get(1),numberDayWeek,"Любые свежие фрукты (кроме банана, винограда, инжира, хурмы)",170, 272);
        addFoodMenu(foodTypeList.get(1),numberDayWeek,"Орехи любые, кроме арахиса, без соли (10 шт)",70, 250);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Суп вегетерианский (овощи+вода) – по желанию",300, 150);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Говядина (на пару, отварная, запечённая)",150, 325);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Салат из рукколы, авокадо, помидоров с растительным маслом",200, 170);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Хлеб цельнозерновой, ржаной или чёрный подсушенный  с сыром",40, 150);
        addFoodMenu(foodTypeList.get(3),numberDayWeek,"Кефир, йогурт натуральный, без добавок-до 2,5% (без фруктов, ягод, шоколада). Можно добавить 1-2 чайн. ложки отрубей",250, 165);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Рыба нежирных сортов или морепродукты: треска. Тмлапия, дорада, окунь, камбала, ледяная рыба и др",100, 180);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Овощи любые (кабачки, цветная капуста, спаржа, шпинат, фасоль сручковая и другие",200, 130);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Хлеб цельнозерновой, ржаной или чёрный подсушенный  с сыром",40, 150);
        addFoodMenu(foodTypeList.get(5),numberDayWeek,"Кефир (до 1%) или настой плодов шиповника или травяной чай",200, 110);
    }
    private void fillWednesday(){
        final int numberDayWeek = 2;
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Свежий творог (до 5%) или сырники, запечённые в духовке",120, 133);
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Хлеб цельнозерновой, ржаной или чёрный подсушенный  с рикоттой и авокадо ",40, 200);
        addFoodMenu(foodTypeList.get(1),numberDayWeek,"Кефир, йогурт натуральный, без добавок-до 2,5%. ",250, 165);
        addFoodMenu(foodTypeList.get(1),numberDayWeek,"Печенье на выбор",50, 250);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Суп вегетерианский (овощи+вода) – по желанию",300, 150);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Рыба жирных сортов (сёмга, форель, тунец и др.) (на пару, запечённая, гриль)",100, 220);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Салат из свежих овощей и растительного масла (1 ст.л.)",150, 98);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Хлеб цельнозерновой, ржаной или чёрный подсушенный",40, 150);
        addFoodMenu(foodTypeList.get(3),numberDayWeek,"Любые свежие фрукты (кроме банана, винограда, инжира, хурмы)",170, 275);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Куриная грудка, индейка, кролик ",150, 270);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Овощи любые (кабачки, цветная капуста, спаржа, шпинат, фасоль сручковая и другие-на пару)+можно заправить лимонным соком",200, 130);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Хлеб цельнозерновой, ржаной или чёрный подсушенный ",40, 150);
        addFoodMenu(foodTypeList.get(5),numberDayWeek,"Кефир (до 1%), настой плодов шиповника, травяной чай",200, 110);
    }

    private void fillThursday(){
        final int numberDayWeek = 3;
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Каша любая на молоке и воде 1:1 с ягодами или фруктами",150, 225);
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Салат из свежих овощей и зелени с растительным маслом (подсолнечным, оливковым, тыквенным, льняным, кукурузным, виноградным и др.-чередовать)",150, 98);
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Хлеб цельнозерновой, ржаной или чёрный подсушенный  со сливочным маслом",45, 250);
        addFoodMenu(foodTypeList.get(1),numberDayWeek,"Кефир, йогурт натуральный, без добавок-до 2,5%. Можно добавить замороженые или свежие ягоды",250, 165);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Куриная грудка, индейка, кролик",200, 360);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Картофель (вареный или запеченный)",250, 215);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Хлеб цельнозерновой, ржаной или чёрный подсушенный  с сыром",40, 200);
        addFoodMenu(foodTypeList.get(3),numberDayWeek,"Любые свежие фрукты (кроме банана, винограда, инжира, хурмы)",170, 275);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Сыр",50, 200);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Овощи",200, 130);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Напиток без сахара",250, 20);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Орехи любые, кроме арахиса, без соли (10 шт)",70, 250);
        addFoodMenu(foodTypeList.get(5),numberDayWeek,"Кефир (до 1%), настой плодов шиповника, травяной чай",200, 110);
    }

    private void fillFriday(){
        final int numberDayWeek = 4;
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Омлет из куриных белков (3 яйца)",150, 100);
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Салат из свежих овощей и зелени с растительным маслом (подсолнечным, оливковым, тыквенным, льняным, кукурузным, виноградным и др.-чередовать)",100, 37);
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Хлеб цельно зерновой, ржаной или чёрный подсушенный",40, 150);
        addFoodMenu(foodTypeList.get(1),numberDayWeek,"Любые свежие фрукты (кроме банана, винограда, инжира, хурмы)",170, 275);
        addFoodMenu(foodTypeList.get(1),numberDayWeek,"Орехи любые, кроме арахиса, без соли (10 шт)",70, 250);
        addFoodMenu(foodTypeList.get(1),numberDayWeek,"Хлеб цельно зерновой, ржаной или чёрный подсушенный",40, 150);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Суп вегетарианский (овощи+вода) – по желанию",300, 150);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Рыба жирных сортов (сёмга, форель, тунец и др.) (на пару, запечённая, гриль)",100, 220);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Рис (бурый)",100, 43);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Напиток без сахара",250, 10);
        addFoodMenu(foodTypeList.get(3),numberDayWeek,"Йогурт натуральный",250, 170);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Куриная грудка, индейка, кролик ",200, 360);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Овощи любые (кроме картофеля: кабачки, цветная капуста, спаржа, шпинат, фасоль сручковая и другие-на пару)+можно заправить лимонным соком",150, 98);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Хлеб цельнозерновой, ржаной или чёрный подсушенный",40, 150);
        addFoodMenu(foodTypeList.get(5),numberDayWeek,"Настой плодов шиповника, травяной чай",200, 110);
    }

    private void fillSaturday(){
        final int numberDayWeek = 5;
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Каша любая на воде с мёдом",250, 375);
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Хлеб цельнозерновой, ржаной или чёрный подсушенный  с сыром",40, 150);
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Напиток без сахара",200, 15);
        addFoodMenu(foodTypeList.get(1),numberDayWeek,"Любые свежие фрукты (кроме банана, винограда, инжира, хурмы)",170, 275);
        addFoodMenu(foodTypeList.get(1),numberDayWeek,"Орехи любые, кроме арахиса, без соли (10 шт)",70, 250);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Суп вегетерианский (овощи+вода) – по желанию",300, 150);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Говядина (на пару, отварная, запечённая)",150, 325);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Салат из рукколы, авокадо, помидоров с растительным маслом",200, 170);
        addFoodMenu(foodTypeList.get(3),numberDayWeek,"Кефир, йогурт натуральный, без добавок-до 2,5% (без фруктов, ягод, шоколада). Можно добавить 1-2 чайн. ложки отрубей",250, 137);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Морепродукты (меньше соли)",200, 412);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Овощи любые (кабачки, цветная капуста, спаржа, шпинат, фасоль сручковая и другие",200, 130);
        addFoodMenu(foodTypeList.get(5),numberDayWeek,"Кефир (до 1%) или настой плодов шиповника или травяной чай",200, 110);
    }

    private void fillSunday(){
        final int numberDayWeek = 6;
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Хлеб цельнозерновой, ржаной или чёрный подсушенный  с рикоттой и авокадо",40, 200);
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Напиток без сахара",200, 15);
        addFoodMenu(foodTypeList.get(0),numberDayWeek,"Свежий творог (до 5%) или сырники, запечённые в духовке",170, 200);
        addFoodMenu(foodTypeList.get(1),numberDayWeek,"Напиток без сахара",200, 15);
        addFoodMenu(foodTypeList.get(1),numberDayWeek,"Печенье на выбор",50, 250);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Суп вегетерианский (овощи+вода) – по желанию",300, 150);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Рыба жирных сортов (сёмга, форель, тунец и др.) (на пару, запечённая, гриль)",200, 440);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Салат из свежих овощей и зелени ", 100, 37);
        addFoodMenu(foodTypeList.get(2),numberDayWeek,"Хлеб цельно зерновой, ржаной или чёрный подсушенный",40, 150);
        addFoodMenu(foodTypeList.get(3),numberDayWeek,"Любые свежие фрукты (кроме банана, винограда, инжира, хурмы)",170, 275);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Куриная грудка, индейка, кролик",200, 360);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Овощи любые (кабачки, цветная капуста, спаржа, шпинат, фасоль сручковая и другие-на пару)+можно заправить лимонным соком",200, 130);
        addFoodMenu(foodTypeList.get(4),numberDayWeek,"Хлеб цельно зерновой, ржаной или чёрный подсушенный",40, 150);
        addFoodMenu(foodTypeList.get(5),numberDayWeek,"Кефир (до 1%), настой плодов шиповника, травяной чай",200, 110);
    }
}
