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

		// �ж�һ���ļ����Ƿ���ڣ�����������򴴽�һ ��
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}

		// Ҫ���ж�name�Ƿ����
		if ("".equals(name) || name == null) {
			return "0";
		}

		// �ж��ϴ��ļ����Ƿ�Ϊ��
		if (!upload.isEmpty() && upload.size() > 0) {

			// ѭ���Ķ�ȡ����
			for (MultipartFile file : upload) {// forEach�﷨
				String origin = file.getOriginalFilename();

				// ��ֹ�ļ�����:1.�ü����빤�� 2.�Լ���д:��ǰʱ���+6λ���������--20191230090823333+6λ�����
				String sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
				String newname = name + "_" + sdf + "_" + origin;// �����ļ������֣�ȷ���ļ���������
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

	//���ָ���ļ�������������ļ��б�
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
		//���õ������ݷŵ�request����
		model.addAttribute("list", list);
		return "download";
	}
	
	@RequestMapping(value = "/download")
	@ResponseBody
	public ResponseEntity<byte[]> download(HttpServletRequest request, String filename) {
		System.out.println("Ҫ���ص��ļ�������:" + filename);
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

	// ��װ һ����������ļ�����ʾ�������������
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