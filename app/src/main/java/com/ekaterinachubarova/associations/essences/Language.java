package com.ekaterinachubarova.associations.essences;

import android.content.Context;

import com.ekaterinachubarova.associations.R;

/**
 * Created by ekaterinachubarova on 18.08.16.
**/

public class Language {

    public static Language rus;
    public static Language en ;
    private static boolean currentLanguageFlag;
    private static Language currentLanguage;

    private String button;
    private String title;
    private String message;
    private int pictureId1;
    private int pictureId2;
    private String yes;
    private String no;
    private String gameRulesTitle;
    private String gameRules;
    private String exit;
    private String check;
    private String inputHere;
    private String level;
    private String finalMessage;
    private String chooseLevel;
    private String newGame;
    private String newGameQuestion;
    private String incorrectMessage;
    private String incorrectAnswer;

    private static Settings settings;
    private Context context;


    public static Language  newInstanceRussian () {
        if (rus == null) {
            rus = new Language();
            setRussian();
        } return rus;
    }

    private static Language newInstanceEnglish (Context context) {
        if (en == null) {
            en = new Language(context);
            setEnglish();
        } return en;
    }

    public static Language changeAndGetCurrentLanguage (Context context){
        settings.setLanguage(!currentLanguageFlag);
        //settings.saveSettings();
        return getCurrentLanguage(context);
    }

    private Language (Context context) {
        this.context = context;
        settings = Settings.get(context);
    }
    private Language () {

    }

    public static Language getCurrentLanguage (Context context) {
        if (en == null) {
            en = newInstanceEnglish(context);
        } if (rus == null) {
            rus = newInstanceRussian();
        }
        currentLanguageFlag = settings.isLanguage();
        if (currentLanguageFlag)
            currentLanguage = newInstanceEnglish(context);
        else {
            currentLanguage = newInstanceRussian();
        }
        return currentLanguage;
    }

    public String getNewGame() {
        return newGame;
    }

    public void setNewGame(String newGame) {
        this.newGame = newGame;
    }

    public String getNewGameQuestion() {
        return newGameQuestion;
    }

    public void setNewGameQuestion(String newGameQuestion) {
        this.newGameQuestion = newGameQuestion;
    }

    public String getChooseLevel() {
        return chooseLevel;
    }

    public void setChooseLevel(String chooseLevel) {
        this.chooseLevel = chooseLevel;
    }

    public String getFinalMessage() {
        return finalMessage;
    }

    public void setFinalMessage(String finalMessage) {
        this.finalMessage = finalMessage;
    }

    public String getYes() {
        return yes;
    }

    public void setYes(String yes) {
        this.yes = yes;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getGameRulesTitle() {
        return gameRulesTitle;
    }

    public void setGameRulesTitle(String gameRulesTitle) {
        this.gameRulesTitle = gameRulesTitle;
    }

    public String getGameRules() {
        return gameRules;
    }

    public void setGameRules(String gameRules) {
        this.gameRules = gameRules;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getInputHere() {
        return inputHere;
    }

    public void setInputHere(String inputHere) {
        this.inputHere = inputHere;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getPictureId1() {
        return pictureId1;
    }

    public void setPictureId1(int pictureId1) {
        this.pictureId1 = pictureId1;
    }

    public int getPictureId2() {
        return pictureId2;
    }

    public void setPictureId2(int pictureId2) {
        this.pictureId2 = pictureId2;
    }


    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIncorrectMessage() {
        return incorrectMessage;
    }

    public void setIncorrectMessage(String incorrectMessage) {
        this.incorrectMessage = incorrectMessage;
    }

    public String getIncorrectAnswer() {
        return incorrectAnswer;
    }

    public void setIncorrectAnswer(String incorrectAnswer) {
        this.incorrectAnswer = incorrectAnswer;
    }

    private static void setEnglish () {
        en.pictureId1 = R.drawable.ic_lang_ru;
        en.pictureId2 = R.drawable.ic_lang_en_1;
        en.button = "Next level";
        en.check = "Check";
        en.chooseLevel = "Choose level";
        en.finalMessage = "Congratulations!!! All levels are completed! \n Play again?";
        en.gameRules = "At the beginning of the game you have 35 coins. The game consists of 25 levels, on each level " +
                "you will have to guess country by the pictures. On each level you can unlock 6 pictures. To unlock one picture " +
                "you should to pay 1 coin. " + "Completing each level gives you 2 coins. ";
        en.exit = "Exit: Are you sure?";
        en.gameRulesTitle = "Game rules";
        en.inputHere = "Input here";
        en.yes = "Yes";
        en.no = "No";
        en.newGameQuestion = "Do you want to start new game?";
        en.newGame = "New game";
        en.level = "Level";
        en.message = "New level is available";
        en.incorrectAnswer = "Try again";
        en.incorrectMessage = "Incorrect answer.";
    }
    private static void setRussian (){
        rus.pictureId1 = R.drawable.ic_lang_ru_1;
        rus.pictureId2 = R.drawable.ic_lang_en;
        rus.button = "Следующий уровень";
        rus.check = "Проверить";
        rus.chooseLevel = "Выберете уровень";
        rus.finalMessage = "Поздравляем!!! Все уровни пройдены! \n Начать сначала?";
        rus.gameRules = "В начале игры Вам начисляется 35 монет. Игра состоит из 25 уровней, в каждом из которых Вам предстоит " +
                "угадать страну по картинкам. На каждом уровне Вы можете открыть 6 картинок. За открытие одной у Вас отнимается 1 " +
                "монета. За прохождение каждого уровня начисляются 2 монеты. Если у Вас закончились монеты, то Вы можете открыть " +
                "картинку, просмотрев рекламу.";
        rus.gameRulesTitle = "Правила игры";
        rus.exit = "Выход: Вы уверены?";
        rus.inputHere = "Вводите здесь";
        rus.yes = "Да";
        rus.no = "Нет";
        rus.newGameQuestion = "Вы хотите начать новую игру?";
        rus.newGame = "Новая игра";
        rus.level = "Уровень";
        rus.message = "Новый уровень открыт";
        rus.incorrectAnswer = "Попробуйте еще раз.";
        rus.incorrectMessage = "Ответ неврный.";
    }
}
