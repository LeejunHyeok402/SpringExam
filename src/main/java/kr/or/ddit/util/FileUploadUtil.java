package kr.or.ddit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;


import kr.or.ddit.vo.AttachVO;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;

@Slf4j
public class FileUploadUtil {
	
	private static String uploadFolder = "C:\\eclipse-jee-2020-06-R-win32-x86_64\\workspace\\springProj\\src\\main\\webapp\\resources\\upload"; 
	
	//파일 업로드 실행
	public static List<AttachVO> fileUploadAction(MultipartFile[] multipartFiles,String tid) {
		log.info("파일 업로드를 수행합니다");
		
		List<AttachVO> attachVOList = new ArrayList<AttachVO>();
		
		//1)파일 업로드 수행(연/월/일,UUID)
		File uploadPath = new File(uploadFolder,getFolder());
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		//<input type="file" name="" multiple
		int seq = 1;
		for (MultipartFile multipartFile : multipartFiles) {
			log.info("------------");
			log.info("파일명: "+multipartFile.getOriginalFilename());
			log.info("파일크기 : "+multipartFile.getSize());
			
			//IE처리 => 경로를 제외한 파일명만 추출
			String uploadFileName = multipartFile.getOriginalFilename();
			uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_"+uploadFileName;
			
			File saveFile = new File(uploadPath,uploadFileName);
			//Attach 테이블의 seq 컬럼에 들어갈 값
			
			
			try {
				multipartFile.transferTo(saveFile);
				
				AttachVO attachVO = new AttachVO();
				attachVO.setSeq(seq++);
				attachVO.setTid(tid);
				
				attachVO.setAttachName("/"+getFolder().replace("\\", "/")+"/"+uploadFileName);
				attachVO.setAttachSize(Long.valueOf(multipartFile.getSize()).intValue());
				attachVO.setAttachType(Files.probeContentType(saveFile.toPath()));
				
				
				attachVOList.add(attachVO);
				
				if(checkImageType(saveFile)) {
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));
					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,100,100);
					thumbnail.close();
				}
			} catch (Exception e) {
				log.info(e.getMessage());
			}
		}
		//2)ATTACH 테이블에 다중 insert
		//SEQ(자동증가), TID, ATTACH_NAME, ATTACH_SIZE, ATTACH_TYPE, REQIST_DATE(SYSDATE)
		for(AttachVO attachVO  :attachVOList) {
			log.info("attachVO: "+attachVO.toString());
		}
		
		
		log.info(attachVOList.toString());
		
		log.info("파일 업로드를 완료했습니다.");
		return attachVOList;
	}
	
	//연/월/일 폴더 생성
	public static String getFolder() {
		//format 지정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//날짜 객체 생성
		Date date = new Date();
		String str = sdf.format(date);
		
		return str.replace("-", File.separator);
	}
	
	
	//이미지인지 체크(썸네일용)
		//모바일과 같은 환경에서 많은 데이터를 소비해야 하므로
		//이미지의 경우 특별한 경우가 아니면 섬네일을 제작해줘야함
	public static boolean checkImageType(File file) {
		/*
		 	jpeg/ jpg(jpeg 이미지)의 MIME 타입: image/jpeg
		 	//MIME 타입을 통해 이미지 여부 확인
		 	file.toPath() : 파일 객체를 Path객체로 변화
		 */
		String contentType;
		try {
			contentType = Files.probeContentType(file.toPath());
			log.info("contentType: "+contentType);
			return contentType.startsWith("image");
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return false;
	}
}
