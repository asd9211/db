package osf.food;

import java.util.HashMap;
import java.util.Map;

import osf.food.controller.FoodController;

public class Execute {
	private FoodController fc = new FoodController();
	
	public static void main(String[] args) {
		Map<String,String> req = new HashMap<>();
		Map<String,Object> res = new HashMap<>();
		Execute e = new Execute();
		try {
			req.put("cmd", "list");
			e.fc.doGet(req, res);
			System.out.println(res);
			
			req = new HashMap<>();
			res = new HashMap<>();
			req.put("cmd", "food");
			req.put("foodNum", "2");
			e.fc.doGet(req, res);
			System.out.println(res);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			req = new HashMap<>();
			res = new HashMap<>();
			req.put("cmd", "update");
			req.put("foodNum", "2");
			req.put("foodName", "고갈비");
			req.put("foodPrice", "26600");
			e.fc.doPost(req, res);
			System.out.println(res);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(res);
		

		try {
			req = new HashMap<>();
			res = new HashMap<>();
			req.put("cmd", "insert");
			req.put("foodNum", "7");
			req.put("foodName", "갈비");
			req.put("foodPrice", "26600");
			e.fc.doPost(req, res);
			System.out.println(res);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(res);
		
		
		req = new HashMap<>();
		res = new HashMap<>();
		req.put("cmd", "insert");
	}
}
