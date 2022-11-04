package kr.or.ddit.vo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


public class BoardMemberVO {
	//필수 입력
	private String memId;
	private String memPass = "asdfasdf";
	
	//필수입력+ 최대 3글자까지 허용
	private String memName;
	private String memRegno1 = "760115";
	private String memRegno2 = "1406420";
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date memBir;
	private String memZip = "-1";
	private String memAdd1 = "-1";
	private String memAdd2 = "-1";
	private String memHometel = "-1";
	private String memComtel = "-1";
	private String memHp;
	private String memMail = "-1";
	private String memJob;
	private String memLike;
	private String memMemorial ="-1";
	private Date memMemorialday;
	private int memMileage = -1;
	private String memDelete =  "";
	
	private String introduction;
	
	//이미지 가져오기 용
	private String filename;
	
	private List<AttachVO> attachVOList;
	
	private MultipartFile[] memberImage;
	
	private String userId;
	private String password;
	private MultipartFile picture;
	private MultipartFile picture2;
	private List<MultipartFile> pictureList;
	private MultipartFile[] pictureArray;
	
	private int coin = 100;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;
	
	private String gender;
	
	private String nationality;
	
	private String[] cars;
	private String car;
	
	private String[] hobbyList;
	private String hobby;
	
	private boolean merriaged;

	//중첩된 자바빈
	private AddressVO addressVO;
	
	private List<CardVO> cardVOList;
	//개발자 여부
	private String developer;
	//외국인 여부
	private boolean foreigner;
	
	public BoardMemberVO() {}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPass() {
		return memPass;
	}

	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemRegno1() {
		return memRegno1;
	}

	public void setMemRegno1(String memRegno1) {
		this.memRegno1 = memRegno1;
	}

	public String getMemRegno2() {
		return memRegno2;
	}

	public void setMemRegno2(String memRegno2) {
		this.memRegno2 = memRegno2;
	}

	public Date getMemBir() {
		return memBir;
	}

	public void setMemBir(Date memBir) {
		this.memBir = memBir;
		this.memMemorialday = memBir;
	}

	public String getMemZip() {
		return memZip;
	}

	public void setMemZip(String memZip) {
		this.memZip = memZip;
	}

	public String getMemAdd1() {
		return memAdd1;
	}

	public void setMemAdd1(String memAdd1) {
		this.memAdd1 = memAdd1;
	}

	public String getMemAdd2() {
		return memAdd2;
	}

	public void setMemAdd2(String memAdd2) {
		this.memAdd2 = memAdd2;
	}

	public String getMemHometel() {
		return memHometel;
	}

	public void setMemHometel(String memHometel) {
		this.memHometel = memHometel;
	}

	public String getMemComtel() {
		return memComtel;
	}

	public void setMemComtel(String memComtel) {
		this.memComtel = memComtel;
	}

	public String getMemHp() {
		return memHp;
	}

	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}

	public String getMemMail() {
		return memMail;
	}

	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}

	public String getMemJob() {
		return memJob;
	}

	public void setMemJob(String memJob) {
		this.memJob = memJob;
	}

	public String getMemLike() {
		return memLike;
	}

	public void setMemLike(String memLike) {
		this.memLike = memLike;
	}

	public String getMemMemorial() {
		return memMemorial;
	}

	public void setMemMemorial(String memMemorial) {
		this.memMemorial = memMemorial;
	}

	public Date getMemMemorialday() {
		return memMemorialday;
	}

	public void setMemMemorialday(Date memMemorialday) {
		this.memMemorialday = memMemorialday;
	}

	public int getMemMileage() {
		return memMileage;
	}

	public void setMemMileage(int memMileage) {
		this.memMileage = memMileage;
	}

	public String getMemDelete() {
		return memDelete;
	}

	public void setMemDelete(String memDelete) {
		this.memDelete = memDelete;
	}

	public MultipartFile[] getMemberImage() {
		return memberImage;
	}

	public void setMemberImage(MultipartFile[] memberImage) {
		this.memberImage = memberImage;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}

	public MultipartFile getPicture2() {
		return picture2;
	}

	public void setPicture2(MultipartFile picture2) {
		this.picture2 = picture2;
	}

	public List<MultipartFile> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<MultipartFile> pictureList) {
		this.pictureList = pictureList;
	}

	public MultipartFile[] getPictureArray() {
		return pictureArray;
	}

	public void setPictureArray(MultipartFile[] pictureArray) {
		this.pictureArray = pictureArray;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String[] getCars() {
		return cars;
	}

	public void setCars(String[] cars) {
		this.cars = cars;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String[] getHobbyList() {
		return hobbyList;
	}

	public void setHobbyList(String[] hobbyList) {
		this.hobbyList = hobbyList;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public boolean isMerriaged() {
		return merriaged;
	}

	public void setMerriaged(boolean merriaged) {
		this.merriaged = merriaged;
	}

	public AddressVO getAddressVO() {
		return addressVO;
	}

	public void setAddressVO(AddressVO addressVO) {
		this.addressVO = addressVO;
	}

	public List<CardVO> getCardVOList() {
		return cardVOList;
	}

	public void setCardVOList(List<CardVO> cardVOList) {
		this.cardVOList = cardVOList;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public boolean isForeigner() {
		return foreigner;
	}

	public void setForeigner(boolean foreigner) {
		this.foreigner = foreigner;
	}

	public List<AttachVO> getAttachVOList() {
		return attachVOList;
	}

	public void setAttachVOList(List<AttachVO> attachVOList) {
		this.attachVOList = attachVOList;
	}

	@Override
	public String toString() {
		return "BoardMemberVO [memId=" + memId + ", memPass=" + memPass + ", memName=" + memName + ", memRegno1="
				+ memRegno1 + ", memRegno2=" + memRegno2 + ", memBir=" + memBir + ", memZip=" + memZip + ", memAdd1="
				+ memAdd1 + ", memAdd2=" + memAdd2 + ", memHometel=" + memHometel + ", memComtel=" + memComtel
				+ ", memHp=" + memHp + ", memMail=" + memMail + ", memJob=" + memJob + ", memLike=" + memLike
				+ ", memMemorial=" + memMemorial + ", memMemorialday=" + memMemorialday + ", memMileage=" + memMileage
				+ ", memDelete=" + memDelete + ", introduction=" + introduction + ", filename=" + filename
				+ ", attachVOList=" + attachVOList + ", memberImage=" + Arrays.toString(memberImage) + ", userId="
				+ userId + ", password=" + password + ", picture=" + picture + ", picture2=" + picture2
				+ ", pictureList=" + pictureList + ", pictureArray=" + Arrays.toString(pictureArray) + ", coin=" + coin
				+ ", birth=" + birth + ", gender=" + gender + ", nationality=" + nationality + ", cars="
				+ Arrays.toString(cars) + ", car=" + car + ", hobbyList=" + Arrays.toString(hobbyList) + ", hobby="
				+ hobby + ", merriaged=" + merriaged + ", addressVO=" + addressVO + ", cardVOList=" + cardVOList
				+ ", developer=" + developer + ", foreigner=" + foreigner + "]";
	}



}
