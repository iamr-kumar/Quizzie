package com.example.quizzie

object Constants {
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

        questionsList.add(que1);
        questionsList.add(que2);
        questionsList.add(que3);
        questionsList.add(que4);
        questionsList.add(que5);
        questionsList.add(que6);

        return questionsList;
    }
}