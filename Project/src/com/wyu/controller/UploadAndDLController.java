package com.wyu.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadAndDLController {

	private String dir = "D:\\upload";

	@RequestMapping(value = "/upload")
	@ResponseBody
	public String upload(@RequestParam("name") String name, @RequestParam("upload") List<MultipartFile> upload) {
		System.out.println("name===>" + name);
		File dirPath = new File(dir);

		// 判断一个文件夹是否存在，如果不存在则创建一 个
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}

		// 要先判断name是否可用
		if ("".equals(name) || name == null) {
			return "0";
		}

		// 判断上传的集合是否为空
		if (!upload.isEmpty() && upload.size() > 0) {

			// 循环的读取数据
			for (MultipartFile file : upload) {// forEach语法
				String origin = file.getOriginalFilename();

				// 防止文件重名:1.用激活码工具 2.自己编写:当前时间戳+6位以上随机数--20191230090823333+6位随机数
				String sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
				String newname = name + "_" + sdf + "_" + origin;// 处理文件的名字，确保文件不会重名
				try {
					file.transferTo(new File(dir + "\\" + newname));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return "1";
		}

		return "0";
	}

	//获得指定文件夹下面的所有文件列表
	@RequestMapping(value = "/getFiles")
	public String getFiles(Model model) {
		File dirPath = new File(dir);
		Queue<File> queue = new LinkedList<>();
		queue.offer(dirPath);
		List<String> list = new LinkedList<>();
		while (!queue.isEmpty()) {
			File root = queue.poll();
			File[] files = root.listFiles();
			for (File file : files) {
				list.add(file.getName());
			}
		}
		//将得到的数据放到request域中
		model.addAttribute("list", list);
		return "download";
	}
	
	@RequestMapping(value = "/download")
	@ResponseBody
	public ResponseEntity<byte[]> download(HttpServletRequest request, String filename) {
		System.out.println("要下载的文件名字是:" + filename);
		File file = new File(dir + "\\" + filename);
		try {
			filename = this.getFilename(request, filename);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", filename);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		try {
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 封装 一个解决下载文件是显示中文乱码的问题
	public String getFilename(HttpServletRequest request, String filename) throws Exception {
		System.out.println("filename===" + filename);
		String[] IEBrowserKeyWord = { "MSIE", "Trident", "Edge" };
		String userAgent = request.getHeader("User-Agent");
		for (String keyWord : IEBrowserKeyWord) {
			if (userAgent.contains(keyWord)) {
				return URLEncoder.encode(filename, "UTF-8");
			}
		}
		return new String(filename.getBytes("UTF-8"), "IS0-8859-1");
	}

}