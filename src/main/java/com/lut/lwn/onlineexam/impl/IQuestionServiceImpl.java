package com.lut.lwn.onlineexam.impl;
/*
 *随机出题 
 * 题库信息，增删改查
 * 按题目类型查询
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.lut.lwn.onlineexam.api.IQuestionService;
import com.lut.lwn.onlineexam.bean.Questions;
import com.lut.lwn.onlineexam.repo.QuestionsRepository;

@CrossOrigin
@RestController
public class IQuestionServiceImpl implements IQuestionService {

	@Autowired
	private QuestionsRepository questionsRepository;

	@Override
	public List<Questions> findAllQuestion() {

		List<Questions> findAll = questionsRepository.findAll();

		return findAll;
	}


	@Override
	public int deleteQuestionById(Long questionId) {
		questionsRepository.deleteById(questionId);
		return 0;
	}

	@Override
	// questionId这个参数不应该存在，不需要他，我们将来根据自己造的随机数去调用findById
	public List<Questions> randomQuestionById() {
		// 用于存放题目
		List<Questions> randomQuestions = new ArrayList<>();
		// 首先查询数据库中所有的ID，作为一个list返回
		List<Long> findRandomId = questionsRepository.findRandomId();
		// System.out.println(findAllIds);

		List sources = new ArrayList(findRandomId);
		List targetList = new ArrayList(12);
		Random random = new Random();
		for (int k = 0; k < 12; k++) {
			int i = random.nextInt(sources.size());
			targetList.add(sources.get(i));
			// 取完后，从目标list内移除该数据
			sources.remove(i);
		}
		for (int j = 0; j < targetList.size(); j++) {
			long id = (long) targetList.get(j);
			// 通过获取的所技术，作为findById的参数去查询，然后查完放入randomQuestions集合中
			Optional<Questions> question = questionsRepository.findById(id);
			// 将获取到的添加到题库中
			randomQuestions.add(question.get());
			
		}

		return randomQuestions;
	}


	@Override
	public String addQuestion(HashMap<String, String> question) {
      Questions questions2 = new Questions();
      questions2.setAnswer(question.get("answer"));
      questions2.setQuestion(question.get("question"));
      questions2.setOptionA(question.get("optionA"));
      questions2.setOptionB(question.get("optionB"));
      questions2.setOptionC(question.get("optionC"));
      questions2.setOptionD(question.get("optionD"));
      questions2.setType(question.get("type"));
      questions2.setScore(question.get("score"));
      
      questionsRepository.save(questions2);
		return null;
	}
}
