package com.lut.lwn.onlineexam.impl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
import com.lut.lwn.onlineexam.bean.ExamPage;
import com.lut.lwn.onlineexam.bean.Questions;
import com.lut.lwn.onlineexam.repo.ExamPageRepository;
import com.lut.lwn.onlineexam.repo.QuestionsRepository;
import com.lut.lwn.onlineexam.repo.StuResultRepository;
import com.lut.lwn.onlineexam.util.CompileUtils;

@CrossOrigin
@RestController
public class IQuestionServiceImpl implements IQuestionService {

	@Autowired
	private QuestionsRepository questionsRepository;
	
	@Autowired
	private ExamPageRepository examPageRepository;
	
	@Autowired
	private StuResultRepository stuResultRepository;
	
	@Autowired
	private CompileUtils compileUtils;

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
		//存考卷
		for (Questions questions : randomQuestions) {
			ExamPage ePage = new ExamPage();
			ePage.setQuestion(questions.getQuestion());
			ePage.setOptionA(questions.getOptionA());
			ePage.setOptionB(questions.getOptionB());
			ePage.setOptionC(questions.getOptionC());
			ePage.setOptionD(questions.getOptionD());
	        ePage.setAnswer(questions.getAnswer());
	        ePage.setName("微微");
	        ePage.setStuId("3");
	        
	        examPageRepository.save(ePage);
	        
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


	@Override
	public List<Questions> randomQuestionProg() {
		System.out.println("随机编程题");
		// 用于存放题目
		List<Questions> randomQuestions = new ArrayList<>();
		// 首先查询数据库中所有的ID，作为一个list返回
		List<Long> findRandomId2 = questionsRepository.findRandomId2();
		Optional<Questions> findById = questionsRepository.findById(findRandomId2.get(0));
		randomQuestions.add(findById.get());
		
		//存考卷
				for (Questions questions : randomQuestions) {
					ExamPage ePage = new ExamPage();
					ePage.setQuestion(questions.getQuestion());
					ePage.setOptionA(questions.getOptionA());
					ePage.setOptionB(questions.getOptionB());
					ePage.setOptionC(questions.getOptionC());
					ePage.setOptionD(questions.getOptionD());
			        ePage.setAnswer(questions.getAnswer());
			        ePage.setName("微微");
			        ePage.setStuId("3");
			        
			        examPageRepository.save(ePage);
			        
				}
				
		return randomQuestions;
	}


	@Override
	public void saveSelectResult(Long userId, int selectResult) {
		stuResultRepository.saveSelectResult(userId,selectResult);
		
	}


	/* (non-Javadoc)
	 * @see com.lut.lwn.onlineexam.api.IQuestionService#excuteProgram(java.lang.String, java.lang.String)
	 */
	@Override
	public String excuteProgram(String content) {
		String str = content;

		try {
			String decode = java.net.URLDecoder.decode(str,"UTF-8");
			System.out.println(decode);
			writeByFileOutputStream(decode);
			//调用运行   运行有问题，根据运行方法返回值返回报错的前端。
			String comm = compileUtils.comm();
			return comm;
		}//特殊字符解码
 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 
		return null;
	}
	/**
     * 向文件中写入内容
     * @param filepath 文件路径与名称
     * @param newstr  写入的内容
     * @return
     * @throws IOException
     */
	public void writeByFileOutputStream(String content) {  
		  
        FileOutputStream fop = null;  
        File file;  
       
        try {  
            file = new File("C:\\Users\\Administrator\\test1.cpp");  
            fop = new FileOutputStream(file);  
            // if file doesnt exists, then create it  
            if (!file.exists()) {  
                file.createNewFile();  
            }  
            // get the content in bytes  
            byte[] contentInBytes = content.getBytes();  
  
            fop.write(contentInBytes);  
            fop.flush();  
            fop.close();  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (fop != null) {  
                    fop.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}
