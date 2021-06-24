package kodlamaio.hrms.business.constants;

public class Messages {
	//list
	public static String listCandidate = "Adaylar listelendi!";
	public static String listEmployee = "Çalışanlar listelendi!";
	public static String listEmployer = "İşverenler listelendi!";
	public static String listJobPosition = "İş pozisyonları listelendi!";
	public static String listUser = "Kullanıcılar listelendi!";
	public static String listActivationCode = "Aktivasyon kodları listelendi!";
	
	//add
	public static String addJobPosition = "İş pozisyonu eklendi!";
	public static String addEmployer = "İşveren eklendi!";
	public static String addEmployee = "Çalışan eklendi!";
	public static String addCandidate = "Aday eklendi!";
	public static String addUser = "Kullanıcı eklendi!";
	
	//candidate
	public static String firstNameCannotBeEmpty = "Lütfen isminizi boş geçmeyiniz!";
	public static String lastNameCannotBeEmpty = "Lütfen soyisminizi boş geçmeyiniz!";
	public static String birthDateCannotBeEmpty = "Lütfen doğum yılınızı boş geçmeyiniz!";
	public static String emailAlreadyValid = "Email doğrulaması zaten geçerli!";
	public static String mernisVerificationIsNotValid = "Mernis doğrulaması geçerli değil!";
	public static String previouslyRegisteredEmailOrNationalIdentity = "Daha önce kayıtlı bir e-posta veya tcno bulunmaktadır!";
	
	//employer
	public static String companyNameCannotBeEmpty = "Lütfen firma isminizi boş geçmeyiniz!";
	public static String webAddressCannotBeEmpty = "Lütfen web adresinizi boş geçmeyiniz!";
	public static String phoneNumberCannotBeEmpty = "Lütfen telefon numaranızı boş geçmeyiniz!";
	public static String domainVerificationIsNotValid = "Domain doğrulaması geçerli değil!";
	
	//user
	public static String emailCannotBeEmpty = "Lütfen email adresinizi boş gecmeyiniz!";
	public static String passwordCannotBeEmpty = "Lütfen şifrenizi boş geçmeyiniz!";
	public static String repasswordCannotBeEmpty = "Lütfen sifre tekrar alanını boş geçmeyiniz!";
	public static String passwordMinimumSixCharacter = "Lütfen sifrenizi 6 karakterden az girmeyiniz!";
	public static String passwordAndRepasswordDoNotMatch = "Şifre ile şifre tekrar uyuşmuyor!";
	public static String userIdMustBeGreaterThanZero = "Kullanıcı numarası 0'dan büyük olmalıdır!";

	//activation code
	public static String userActivationSuccessfully = "Kullanici aktivasyonu gerçekleşti!";
	
	//job position
	public static String jobPositionCannotBeRepeated = "Bu iş pozisyonu tekrar edemez!";

}
