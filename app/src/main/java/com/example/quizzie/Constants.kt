package com.example.quizzie

object Constants {

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTIONS:String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answer"

    fun getQuestion(): ArrayList<QuestionModel> {
        val questionsList = ArrayList<QuestionModel>();

        val que1 = QuestionModel(
            1,
            "What country does this flag belong to?", R.drawable.ic_flag_of_germany,
            "India",
            "Finland",
            "Germany",
            "Austria",
            3
        );

        val que2 = QuestionModel(
            1,
            "What country does this flag belong to?", R.drawable.ic_flag_of_argentina,
            "USA",
            "Pakistan",
            "Australia",
            "Argentina",
            4
        );

        val que3 = QuestionModel(
            1,
            "What country does this flag belong to?", R.drawable.ic_flag_of_belgium,
            "Canada",
            "Belgium",
            "Spain",
            "England",
            2
        );

        val que4 = QuestionModel(
            1,
            "What country does this flag belong to?", R.drawable.ic_flag_of_brazil,
            "Malasiya",
            "Brazil",
            "Germany",
            "Indonasia",
            2
        );

        val que5 = QuestionModel(
            1,
            "What country does this flag belong to?", R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Sri Lanka",
            "Japan",
            "India",
            1
        );

        val que6 = QuestionModel(
            1,
            "What country does this flag belong to?", R.drawable.ic_flag_of_india,
            "France",
            "Fiji",
            "India",
            "Argentina",
            3
        );

        val que7 = QuestionModel(
            1,
            "What country does this flag belong to?", R.drawable.ic_flag_of_australia,
            "Australia",
            "Japan",
            "New Zealand",
            "England",
            1
        );

        val que8 = QuestionModel(
            1,
            "What country does this flag belong to?", R.drawable.ic_flag_of_fiji,
            "Spain",
            "Fiji",
            "Indonasia",
            "Greenland",
            2
        );

        val que9 = QuestionModel(
            1,
            "What country does this flag belong to?", R.drawable.ic_flag_of_kuwait,
            "Austalia",
            "USA",
            "Germany",
            "Kuwait",
            4
        );

        val que10 = QuestionModel(
            1,
            "What country does this flag belong to?", R.drawable.ic_flag_of_new_zealand,
            "Honk Kong",
            "New Zealand",
            "India",
            "Bhutan",
            2
        );

        questionsList.add(que1);
        questionsList.add(que2);
        questionsList.add(que3);
        questionsList.add(que4);
        questionsList.add(que5);
        questionsList.add(que6);
        questionsList.add(que7);
        questionsList.add(que8);
        questionsList.add(que9);
        questionsList.add(que10);

        return questionsList;
    }
}