package kodlamaio.hrms.business.constants;

public class Messages {
	//list
	public static String listCandidate = "Adaylar listelendi!";
	public static String listEmployee = "Çalışanlar listelendi!";
	public static String listEmployer = "İşverenler listelendi!";
	public static String listJobPosition = "İş pozisyonları listelendi!";
	public static String listUser = "Kullanıcılar listelendi!";
	public static String listActivationCode = "Aktivasyon kodları listelendi!";
	public static String listCity = "Şehirler listelendi!";
	public static String listJobAdvertisement = "İş ilanları listelendi!";
	
	//add
	public static String addJobPosition = "İş pozisyonu eklendi!";
	public static String addEmployer = "İşveren eklendi!";
	public static String addEmployee = "Çalışan eklendi!";
	public static String addCandidate = "Aday eklendi!";
	public static String addUser = "Kullanıcı eklendi!";
	public static String addCity = "Şehir eklendi!";
	public static String addJobAdvertisement = "İş ilanı eklendi!";
	
	//candidate
	public static String firstNameCannotBeEmpty = "Lütfen isminizi boş geçmeyiniz!";
	public static String lastNameCannotBeEmpty = "Lütfen soyisminizi boş geçmeyiniz!";
	public static String birthDateCannotBeEmpty = "Lütfen doğum yılınızı boş geçmeyiniz!";
	public static String nationalIdentityCannotBeEmpty = "Lütfen kimlik numaranızı boş geçmeyiniz!";
	public static String emailAlreadyValid = "Email doğrulaması zaten geçerli!";
	public static String emailPatternNotValid = "Girimiş olduğunuz email adresi geçerli değil!";
	public static String mernisVerificationIsNotValid = "Mernis doğrulaması geçerli değil!";
	public static String previouslyRegisteredEmailOrNationalIdentity = "Daha önce kayıtlı bir e-posta veya tcno bulunmaktadır!";
	
	//employer
	public static String companyNameCannotBeEmpty = "Lütfen firma isminizi boş geçmeyiniz!";
	public static String webAddressCannotBeEmpty = "Lütfen web adresinizi boş geçmeyiniz!";
	public static String phoneNumberCannotBeEmpty = "Lütfen telefon numaranızı boş geçmeyiniz!";
	public static String domainVerificationIsNotValid = "Domain doğrulaması geçerli değil!";
	public static String employerDoesNotExist = "Böyle bir iş veren sistemde kayıtlı değil!";
	
	//user
	public static String emailCannotBeEmpty = "Lütfen email adresinizi boş gecmeyiniz!";
	public static String passwordCannotBeEmpty = "Lütfen şifrenizi boş geçmeyiniz!";
	public static String repasswordCannotBeEmpty = "Lütfen sifre tekrar alanını boş geçmeyiniz!";
	public static String passwordMinimumSixCharacter = "Lütfen sifrenizi 6 karakterden az girmeyiniz!";
	public static String passwordAndRepasswordDoNotMatch = "Şifre ile şifre tekrar uyuşmuyor!";
	public static String userIdMustBeGreaterThanZero = "Kullanıcı numarası 0'dan büyük olmalıdır!";
	public static String userDoesNotExist = "Böyle bir kullanıcı mevcut değil!";

	//activation code
	public static String userActivationSuccessfully = "Kullanici aktivasyonu gerçekleşti!";
	
	//job position
	public static String jobPositionCannotBeRepeated = "Bu iş pozisyonu tekrar edemez!";
	public static String jobPositionDoesNotExist = "Böyle bir iş pozisyonu mevcut değil!";
	
	//job advertisement
	public static String openPositionCountGreaterThanZero = "Açık pozisyon adedi 0'dan büyük olmalıdır!";
	public static String jobDescriptionIsRequired = "İş tanımı boş olmamalıdır!";
	public static String deadLineIsRequired = "Son başvuru tarihi boş olmamalıdır!";
	public static String listJobAdvertisementByCompanyName = "Bir firmaya ait iş ilanları listelendi!";
	public static String closedJobAdvertisement = "Bu iş ilanı kapandı!";
	
	//city
	public static String cityDoesNotExist = "Böyle bir şehir mevcut değil!";
	
}
