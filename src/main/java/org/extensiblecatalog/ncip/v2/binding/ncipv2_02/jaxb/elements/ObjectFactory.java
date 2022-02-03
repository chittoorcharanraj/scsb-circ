package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
    private static final QName _DateWillSend_QNAME = new QName("http://www.niso.org/2008/ncip", "DateWillSend");
    private static final QName _BibliographicRecordIdentifier_QNAME = new QName("http://www.niso.org/2008/ncip", "BibliographicRecordIdentifier");
    private static final QName _FromAgencyAuthentication_QNAME = new QName("http://www.niso.org/2008/ncip", "FromAgencyAuthentication");
    private static final QName _Street_QNAME = new QName("http://www.niso.org/2008/ncip", "Street");
    private static final QName _BibliographicLevel_QNAME = new QName("http://www.niso.org/2008/ncip", "BibliographicLevel");
    private static final QName _AgencyElementType_QNAME = new QName("http://www.niso.org/2008/ncip", "AgencyElementType");
    private static final QName _DateCheckedOut_QNAME = new QName("http://www.niso.org/2008/ncip", "DateCheckedOut");
    private static final QName _PhysicalConditionDetails_QNAME = new QName("http://www.niso.org/2008/ncip", "PhysicalConditionDetails");
    private static final QName _AuthenticationDataFormatType_QNAME = new QName("http://www.niso.org/2008/ncip", "AuthenticationDataFormatType");
    private static final QName _RequestIdentifierType_QNAME = new QName("http://www.niso.org/2008/ncip", "RequestIdentifierType");
    private static final QName _PlaceOfPublication_QNAME = new QName("http://www.niso.org/2008/ncip", "PlaceOfPublication");
    private static final QName _ItemDescriptionLevel_QNAME = new QName("http://www.niso.org/2008/ncip", "ItemDescriptionLevel");
    private static final QName _CurrencyCode_QNAME = new QName("http://www.niso.org/2008/ncip", "CurrencyCode");
    private static final QName _DateReturned_QNAME = new QName("http://www.niso.org/2008/ncip", "DateReturned");
    private static final QName _ProblemValue_QNAME = new QName("http://www.niso.org/2008/ncip", "ProblemValue");
    private static final QName _ItemIdentifierType_QNAME = new QName("http://www.niso.org/2008/ncip", "ItemIdentifierType");
    private static final QName _SponsoringBody_QNAME = new QName("http://www.niso.org/2008/ncip", "SponsoringBody");
    private static final QName _ToSystemId_QNAME = new QName("http://www.niso.org/2008/ncip", "ToSystemId");
    private static final QName _DateReceived_QNAME = new QName("http://www.niso.org/2008/ncip", "DateReceived");
    private static final QName _LocationNameLevel_QNAME = new QName("http://www.niso.org/2008/ncip", "LocationNameLevel");
    private static final QName _CareOf_QNAME = new QName("http://www.niso.org/2008/ncip", "CareOf");
    private static final QName _ShippingInstructions_QNAME = new QName("http://www.niso.org/2008/ncip", "ShippingInstructions");
    private static final QName _ComponentIdentifier_QNAME = new QName("http://www.niso.org/2008/ncip", "ComponentIdentifier");
    private static final QName _AuthenticationPromptType_QNAME = new QName("http://www.niso.org/2008/ncip", "AuthenticationPromptType");
    private static final QName _TitleOfComponent_QNAME = new QName("http://www.niso.org/2008/ncip", "TitleOfComponent");
    private static final QName _ValidFromDate_QNAME = new QName("http://www.niso.org/2008/ncip", "ValidFromDate");
    private static final QName _Country_QNAME = new QName("http://www.niso.org/2008/ncip", "Country");
    private static final QName _Author_QNAME = new QName("http://www.niso.org/2008/ncip", "Author");
    private static final QName _TitleHoldQueueLength_QNAME = new QName("http://www.niso.org/2008/ncip", "TitleHoldQueueLength");
    private static final QName _UnstructuredHoldingsData_QNAME = new QName("http://www.niso.org/2008/ncip", "UnstructuredHoldingsData");
    private static final QName _HoldPickupDate_QNAME = new QName("http://www.niso.org/2008/ncip", "HoldPickupDate");
    private static final QName _MaximumItemsCount_QNAME = new QName("http://www.niso.org/2008/ncip", "MaximumItemsCount");
    private static final QName _BibliographicItemIdentifier_QNAME = new QName("http://www.niso.org/2008/ncip", "BibliographicItemIdentifier");
    private static final QName _Suffix_QNAME = new QName("http://www.niso.org/2008/ncip", "Suffix");
    private static final QName _DateSent_QNAME = new QName("http://www.niso.org/2008/ncip", "DateSent");
    private static final QName _UnstructuredAddressData_QNAME = new QName("http://www.niso.org/2008/ncip", "UnstructuredAddressData");
    private static final QName _Edition_QNAME = new QName("http://www.niso.org/2008/ncip", "Edition");
    private static final QName _AuthorOfComponent_QNAME = new QName("http://www.niso.org/2008/ncip", "AuthorOfComponent");
    private static final QName _PickupDate_QNAME = new QName("http://www.niso.org/2008/ncip", "PickupDate");
    private static final QName _Initials_QNAME = new QName("http://www.niso.org/2008/ncip", "Initials");
    private static final QName _ReferenceToResource_QNAME = new QName("http://www.niso.org/2008/ncip", "ReferenceToResource");
    private static final QName _DesiredDateForReturn_QNAME = new QName("http://www.niso.org/2008/ncip", "DesiredDateForReturn");
    private static final QName _UserIdentifierValue_QNAME = new QName("http://www.niso.org/2008/ncip", "UserIdentifierValue");
    private static final QName _PhysicalAddressType_QNAME = new QName("http://www.niso.org/2008/ncip", "PhysicalAddressType");
    private static final QName _FiscalTransactionIdentifierValue_QNAME = new QName("http://www.niso.org/2008/ncip", "FiscalTransactionIdentifierValue");
    private static final QName _OrganizationNameType_QNAME = new QName("http://www.niso.org/2008/ncip", "OrganizationNameType");
    private static final QName _MediumType_QNAME = new QName("http://www.niso.org/2008/ncip", "MediumType");
    private static final QName _ItemIdentifierValue_QNAME = new QName("http://www.niso.org/2008/ncip", "ItemIdentifierValue");
    private static final QName _FiscalActionType_QNAME = new QName("http://www.niso.org/2008/ncip", "FiscalActionType");
    private static final QName _SeriesTitleNumber_QNAME = new QName("http://www.niso.org/2008/ncip", "SeriesTitleNumber");
    private static final QName _CirculationStatus_QNAME = new QName("http://www.niso.org/2008/ncip", "CirculationStatus");
    private static final QName _DateOfBirth_QNAME = new QName("http://www.niso.org/2008/ncip", "DateOfBirth");
    private static final QName _RequiredItemUseRestrictionType_QNAME = new QName("http://www.niso.org/2008/ncip", "RequiredItemUseRestrictionType");
    private static final QName _DateShipped_QNAME = new QName("http://www.niso.org/2008/ncip", "DateShipped");
    private static final QName _EnumerationCaption_QNAME = new QName("http://www.niso.org/2008/ncip", "EnumerationCaption");
    private static final QName _DatePlaced_QNAME = new QName("http://www.niso.org/2008/ncip", "DatePlaced");
    private static final QName _EnumerationLevel_QNAME = new QName("http://www.niso.org/2008/ncip", "EnumerationLevel");
    private static final QName _HoldQueueLength_QNAME = new QName("http://www.niso.org/2008/ncip", "HoldQueueLength");
    private static final QName _UserPrivilegeStatusType_QNAME = new QName("http://www.niso.org/2008/ncip", "UserPrivilegeStatusType");
    private static final QName _ProblemDetail_QNAME = new QName("http://www.niso.org/2008/ncip", "ProblemDetail");
    private static final QName _RenewalCount_QNAME = new QName("http://www.niso.org/2008/ncip", "RenewalCount");
    private static final QName _ElectronicAddressType_QNAME = new QName("http://www.niso.org/2008/ncip", "ElectronicAddressType");
    private static final QName _NumberOfPieces_QNAME = new QName("http://www.niso.org/2008/ncip", "NumberOfPieces");
    private static final QName _ProblemElement_QNAME = new QName("http://www.niso.org/2008/ncip", "ProblemElement");
    private static final QName _Prefix_QNAME = new QName("http://www.niso.org/2008/ncip", "Prefix");
    private static final QName _BibliographicItemIdentifierCode_QNAME = new QName("http://www.niso.org/2008/ncip", "BibliographicItemIdentifierCode");
    private static final QName _AgencyId_QNAME = new QName("http://www.niso.org/2008/ncip", "AgencyId");
    private static final QName _PickupExpiryDate_QNAME = new QName("http://www.niso.org/2008/ncip", "PickupExpiryDate");
    private static final QName _NeedBeforeDate_QNAME = new QName("http://www.niso.org/2008/ncip", "NeedBeforeDate");
    private static final QName _UserIdentifierType_QNAME = new QName("http://www.niso.org/2008/ncip", "UserIdentifierType");
    private static final QName _PublicationDateOfComponent_QNAME = new QName("http://www.niso.org/2008/ncip", "PublicationDateOfComponent");
    private static final QName _DateReportedReturned_QNAME = new QName("http://www.niso.org/2008/ncip", "DateReportedReturned");
    private static final QName _Surname_QNAME = new QName("http://www.niso.org/2008/ncip", "Surname");
    private static final QName _FromSystemAuthentication_QNAME = new QName("http://www.niso.org/2008/ncip", "FromSystemAuthentication");
    private static final QName _NoticeType_QNAME = new QName("http://www.niso.org/2008/ncip", "NoticeType");
    private static final QName _DateDue_QNAME = new QName("http://www.niso.org/2008/ncip", "DateDue");
    private static final QName _PickupLocation_QNAME = new QName("http://www.niso.org/2008/ncip", "PickupLocation");
    private static final QName _LocationWithinBuilding_QNAME = new QName("http://www.niso.org/2008/ncip", "LocationWithinBuilding");
    private static final QName _AcknowledgedItemUseRestrictionType_QNAME = new QName("http://www.niso.org/2008/ncip", "AcknowledgedItemUseRestrictionType");
    private static final QName _Publisher_QNAME = new QName("http://www.niso.org/2008/ncip", "Publisher");
    private static final QName _MonetaryValue_QNAME = new QName("http://www.niso.org/2008/ncip", "MonetaryValue");
    private static final QName _CallNumber_QNAME = new QName("http://www.niso.org/2008/ncip", "CallNumber");
    private static final QName _ComponentIdentifierType_QNAME = new QName("http://www.niso.org/2008/ncip", "ComponentIdentifierType");
    private static final QName _DateForReturn_QNAME = new QName("http://www.niso.org/2008/ncip", "DateForReturn");
    private static final QName _NextItemToken_QNAME = new QName("http://www.niso.org/2008/ncip", "NextItemToken");
    private static final QName _FromSystemId_QNAME = new QName("http://www.niso.org/2008/ncip", "FromSystemId");
    private static final QName _ChronologyCaption_QNAME = new QName("http://www.niso.org/2008/ncip", "ChronologyCaption");
    private static final QName _DesiredDateDue_QNAME = new QName("http://www.niso.org/2008/ncip", "DesiredDateDue");
    private static final QName _ChronologyLevel_QNAME = new QName("http://www.niso.org/2008/ncip", "ChronologyLevel");
    private static final QName _FiscalTransactionType_QNAME = new QName("http://www.niso.org/2008/ncip", "FiscalTransactionType");
    private static final QName _Pagination_QNAME = new QName("http://www.niso.org/2008/ncip", "Pagination");
    private static final QName _NoticeContent_QNAME = new QName("http://www.niso.org/2008/ncip", "NoticeContent");
    private static final QName _RequestIdentifierValue_QNAME = new QName("http://www.niso.org/2008/ncip", "RequestIdentifierValue");
    private static final QName _FiscalTransactionDescription_QNAME = new QName("http://www.niso.org/2008/ncip", "FiscalTransactionDescription");
    private static final QName _AuthenticationPromptData_QNAME = new QName("http://www.niso.org/2008/ncip", "AuthenticationPromptData");
    private static final QName _GivenName_QNAME = new QName("http://www.niso.org/2008/ncip", "GivenName");
    private static final QName _RequestedActionType_QNAME = new QName("http://www.niso.org/2008/ncip", "RequestedActionType");
    private static final QName _UserPrivilegeDescription_QNAME = new QName("http://www.niso.org/2008/ncip", "UserPrivilegeDescription");
    private static final QName _RequestElementType_QNAME = new QName("http://www.niso.org/2008/ncip", "RequestElementType");
    private static final QName _RequestType_QNAME = new QName("http://www.niso.org/2008/ncip", "RequestType");
    private static final QName _District_QNAME = new QName("http://www.niso.org/2008/ncip", "District");
    private static final QName _UserLanguage_QNAME = new QName("http://www.niso.org/2008/ncip", "UserLanguage");
    private static final QName _BinNumber_QNAME = new QName("http://www.niso.org/2008/ncip", "BinNumber");
    private static final QName _Region_QNAME = new QName("http://www.niso.org/2008/ncip", "Region");
    private static final QName _ElectronicAddressData_QNAME = new QName("http://www.niso.org/2008/ncip", "ElectronicAddressData");
    private static final QName _LoanedItemCountValue_QNAME = new QName("http://www.niso.org/2008/ncip", "LoanedItemCountValue");
    private static final QName _UserElementType_QNAME = new QName("http://www.niso.org/2008/ncip", "UserElementType");
    private static final QName _ReminderLevel_QNAME = new QName("http://www.niso.org/2008/ncip", "ReminderLevel");
    private static final QName _HoldingsSetId_QNAME = new QName("http://www.niso.org/2008/ncip", "HoldingsSetId");
    private static final QName _ConsortiumAgreement_QNAME = new QName("http://www.niso.org/2008/ncip", "ConsortiumAgreement");
    private static final QName _HoldQueuePosition_QNAME = new QName("http://www.niso.org/2008/ncip", "HoldQueuePosition");
    private static final QName _LocationNameValue_QNAME = new QName("http://www.niso.org/2008/ncip", "LocationNameValue");
    private static final QName _BibliographicRecordIdentifierCode_QNAME = new QName("http://www.niso.org/2008/ncip", "BibliographicRecordIdentifierCode");
    private static final QName _HouseName_QNAME = new QName("http://www.niso.org/2008/ncip", "HouseName");
    private static final QName _EarliestDateNeeded_QNAME = new QName("http://www.niso.org/2008/ncip", "EarliestDateNeeded");
    private static final QName _Locality_QNAME = new QName("http://www.niso.org/2008/ncip", "Locality");
    private static final QName _AuthenticationInputData_QNAME = new QName("http://www.niso.org/2008/ncip", "AuthenticationInputData");
    private static final QName _ApplicationProfileSupportedType_QNAME = new QName("http://www.niso.org/2008/ncip", "ApplicationProfileSupportedType");
    private static final QName _AgencyUserPrivilegeType_QNAME = new QName("http://www.niso.org/2008/ncip", "AgencyUserPrivilegeType");
    private static final QName _ValidToDate_QNAME = new QName("http://www.niso.org/2008/ncip", "ValidToDate");
    private static final QName _PaymentMethodType_QNAME = new QName("http://www.niso.org/2008/ncip", "PaymentMethodType");
    private static final QName _DateOfExpectedReply_QNAME = new QName("http://www.niso.org/2008/ncip", "DateOfExpectedReply");
    private static final QName _SecurityMarker_QNAME = new QName("http://www.niso.org/2008/ncip", "SecurityMarker");
    private static final QName _UserAddressRoleType_QNAME = new QName("http://www.niso.org/2008/ncip", "UserAddressRoleType");
    private static final QName _DateEventOccurred_QNAME = new QName("http://www.niso.org/2008/ncip", "DateEventOccurred");
    private static final QName _UnstructuredPersonalUserName_QNAME = new QName("http://www.niso.org/2008/ncip", "UnstructuredPersonalUserName");
    private static final QName _EnumerationValue_QNAME = new QName("http://www.niso.org/2008/ncip", "EnumerationValue");
    private static final QName _AccrualDate_QNAME = new QName("http://www.niso.org/2008/ncip", "AccrualDate");
    private static final QName _ItemElementType_QNAME = new QName("http://www.niso.org/2008/ncip", "ItemElementType");
    private static final QName _ApplicationProfileType_QNAME = new QName("http://www.niso.org/2008/ncip", "ApplicationProfileType");
    private static final QName _Language_QNAME = new QName("http://www.niso.org/2008/ncip", "Language");
    private static final QName _PostOfficeBox_QNAME = new QName("http://www.niso.org/2008/ncip", "PostOfficeBox");
    private static final QName _ChronologyValue_QNAME = new QName("http://www.niso.org/2008/ncip", "ChronologyValue");
    private static final QName _DateRecalled_QNAME = new QName("http://www.niso.org/2008/ncip", "DateRecalled");
    private static final QName _RequestedItemCountValue_QNAME = new QName("http://www.niso.org/2008/ncip", "RequestedItemCountValue");
    private static final QName _PostalCode_QNAME = new QName("http://www.niso.org/2008/ncip", "PostalCode");
    private static final QName _CopyNumber_QNAME = new QName("http://www.niso.org/2008/ncip", "CopyNumber");
    private static final QName _ItemNote_QNAME = new QName("http://www.niso.org/2008/ncip", "ItemNote");
    private static final QName _OrganizationName_QNAME = new QName("http://www.niso.org/2008/ncip", "OrganizationName");
    private static final QName _Line2_QNAME = new QName("http://www.niso.org/2008/ncip", "Line2");
    private static final QName _DateRenewed_QNAME = new QName("http://www.niso.org/2008/ncip", "DateRenewed");
    private static final QName _Line1_QNAME = new QName("http://www.niso.org/2008/ncip", "Line1");
    private static final QName _RequestStatusType_QNAME = new QName("http://www.niso.org/2008/ncip", "RequestStatusType");
    private static final QName _DateOfUserRequest_QNAME = new QName("http://www.niso.org/2008/ncip", "DateOfUserRequest");
    private static final QName _LocationType_QNAME = new QName("http://www.niso.org/2008/ncip", "LocationType");
    private static final QName _ItemUseRestrictionType_QNAME = new QName("http://www.niso.org/2008/ncip", "ItemUseRestrictionType");
    private static final QName _DateOfUserPrivilegeStatus_QNAME = new QName("http://www.niso.org/2008/ncip", "DateOfUserPrivilegeStatus");
    private static final QName _DateToSend_QNAME = new QName("http://www.niso.org/2008/ncip", "DateToSend");
    private static final QName _BlockOrTrapType_QNAME = new QName("http://www.niso.org/2008/ncip", "BlockOrTrapType");
    private static final QName _ProblemType_QNAME = new QName("http://www.niso.org/2008/ncip", "ProblemType");
    private static final QName _AgencyAddressRoleType_QNAME = new QName("http://www.niso.org/2008/ncip", "AgencyAddressRoleType");
    private static final QName _DateAvailable_QNAME = new QName("http://www.niso.org/2008/ncip", "DateAvailable");
    private static final QName _AuthenticationInputType_QNAME = new QName("http://www.niso.org/2008/ncip", "AuthenticationInputType");
    private static final QName _PhysicalConditionType_QNAME = new QName("http://www.niso.org/2008/ncip", "PhysicalConditionType");
    private static final QName _ShippingNote_QNAME = new QName("http://www.niso.org/2008/ncip", "ShippingNote");
    private static final QName _Title_QNAME = new QName("http://www.niso.org/2008/ncip", "Title");
    private static final QName _RoutingInstructions_QNAME = new QName("http://www.niso.org/2008/ncip", "RoutingInstructions");
    private static final QName _UnstructuredAddressType_QNAME = new QName("http://www.niso.org/2008/ncip", "UnstructuredAddressType");
    private static final QName _RequestScopeType_QNAME = new QName("http://www.niso.org/2008/ncip", "RequestScopeType");
    private static final QName _ActualResource_QNAME = new QName("http://www.niso.org/2008/ncip", "ActualResource");
    private static final QName _UserElementEnum_QNAME = new QName("http://www.niso.org/2008/ncip", "UserElementEnum");
    private static final QName _PublicationDate_QNAME = new QName("http://www.niso.org/2008/ncip", "PublicationDate");
    private static final QName _ElectronicDataFormatType_QNAME = new QName("http://www.niso.org/2008/ncip", "ElectronicDataFormatType");

    public ObjectFactory() {
    }

    public Ext createExt() {
        return new Ext();
    }

    public SchemeValuePair createSchemeValuePair() {
        return new SchemeValuePair();
    }

    public InitiationHeader createInitiationHeader() {
        return new InitiationHeader();
    }

    public FromAgencyId createFromAgencyId() {
        return new FromAgencyId();
    }

    public OnBehalfOfAgency createOnBehalfOfAgency() {
        return new OnBehalfOfAgency();
    }

    public ToAgencyId createToAgencyId() {
        return new ToAgencyId();
    }

    public MandatedAction createMandatedAction() {
        return new MandatedAction();
    }

    public OrganizationNameInformation createOrganizationNameInformation() {
        return new OrganizationNameInformation();
    }

    public PhysicalAddress createPhysicalAddress() {
        return new PhysicalAddress();
    }

    public StructuredAddress createStructuredAddress() {
        return new StructuredAddress();
    }

    public UnstructuredAddress createUnstructuredAddress() {
        return new UnstructuredAddress();
    }

    public ElectronicAddress createElectronicAddress() {
        return new ElectronicAddress();
    }

    public NameInformation createNameInformation() {
        return new NameInformation();
    }

    public PersonalNameInformation createPersonalNameInformation() {
        return new PersonalNameInformation();
    }

    public StructuredPersonalUserName createStructuredPersonalUserName() {
        return new StructuredPersonalUserName();
    }

    public UserId createUserId() {
        return new UserId();
    }

    public ItemId createItemId() {
        return new ItemId();
    }

    public RequestId createRequestId() {
        return new RequestId();
    }

    public ItemOptionalFields createItemOptionalFields() {
        return new ItemOptionalFields();
    }

    public BibliographicDescription createBibliographicDescription() {
        return new BibliographicDescription();
    }

  /*   public ComponentId createComponentId() {
        return new ComponentId();
    }
*/
    public ItemDescription createItemDescription() {
        return new ItemDescription();
    }

    public Location createLocation() {
        return new Location();
    }

    public LocationName createLocationName() {
        return new LocationName();
    }

    public LocationNameInstance createLocationNameInstance() {
        return new LocationNameInstance();
    }

    public UserOptionalFields createUserOptionalFields() {
        return new UserOptionalFields();
    }

    public UserAddressInformation createUserAddressInformation() {
        return new UserAddressInformation();
    }

    public UserPrivilege createUserPrivilege() {
        return new UserPrivilege();
    }

    public UserPrivilegeStatus createUserPrivilegeStatus() {
        return new UserPrivilegeStatus();
    }

    public BlockOrTrap createBlockOrTrap() {
        return new BlockOrTrap();
    }

    public PreviousUserId createPreviousUserId() {
        return new PreviousUserId();
    }

    public ResponseHeader createResponseHeader() {
        return new ResponseHeader();
    }

    public Problem createProblem() {
        return new Problem();
    }


    public NCIPMessage createNCIPMessage() {
        return new NCIPMessage();
    }

    public AcceptItem createAcceptItem() {
        return new AcceptItem();
    }


    public AcceptItemResponse createAcceptItemResponse() {
        return new AcceptItemResponse();
    }

    public CancelRequestItem createCancelRequestItem() {
        return new CancelRequestItem();
    }

    public CancelRequestItemResponse createCancelRequestItemResponse() {
        return new CancelRequestItemResponse();
    }

    public CheckInItem createCheckInItem() {
        return new CheckInItem();
    }

    public CheckInItemResponse createCheckInItemResponse() {
        return new CheckInItemResponse();
    }

    public RoutingInformation createRoutingInformation() {
        return new RoutingInformation();
    }

    public Destination createDestination() {
        return new Destination();
    }

    public CheckOutItem createCheckOutItem() {
        return new CheckOutItem();
    }

    public CheckOutItemResponse createCheckOutItemResponse() {
        return new CheckOutItemResponse();
    }


    public BibliographicId createBibliographicId() {
        return new BibliographicId();
    }

    public LookupUser createLookupUser() {
        return new LookupUser();
    }

    public LookupUserResponse createLookupUserResponse() {
        return new LookupUserResponse();
    }

    public RecallItem createRecallItem() {
        return new RecallItem();
    }

    public RecallItemResponse createRecallItemResponse() {
        return new RecallItemResponse();
    }


    public RequestItem createRequestItem() {
        return new RequestItem();
    }

    public RequestItemResponse createRequestItemResponse() {
        return new RequestItemResponse();
    }


    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateWillSend"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateWillSend(XMLGregorianCalendar value) {
        return new JAXBElement(_DateWillSend_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "BibliographicRecordIdentifier"
    )
    public JAXBElement<String> createBibliographicRecordIdentifier(String value) {
        return new JAXBElement(_BibliographicRecordIdentifier_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "FromAgencyAuthentication"
    )
    public JAXBElement<String> createFromAgencyAuthentication(String value) {
        return new JAXBElement(_FromAgencyAuthentication_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Street"
    )
    public JAXBElement<String> createStreet(String value) {
        return new JAXBElement(_Street_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "BibliographicLevel"
    )
    public JAXBElement<SchemeValuePair> createBibliographicLevel(SchemeValuePair value) {
        return new JAXBElement(_BibliographicLevel_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "AgencyElementType"
    )
    public JAXBElement<SchemeValuePair> createAgencyElementType(SchemeValuePair value) {
        return new JAXBElement(_AgencyElementType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateCheckedOut"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateCheckedOut(XMLGregorianCalendar value) {
        return new JAXBElement(_DateCheckedOut_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "PhysicalConditionDetails"
    )
    public JAXBElement<String> createPhysicalConditionDetails(String value) {
        return new JAXBElement(_PhysicalConditionDetails_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "AuthenticationDataFormatType"
    )
    public JAXBElement<SchemeValuePair> createAuthenticationDataFormatType(SchemeValuePair value) {
        return new JAXBElement(_AuthenticationDataFormatType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "RequestIdentifierType"
    )
    public JAXBElement<SchemeValuePair> createRequestIdentifierType(SchemeValuePair value) {
        return new JAXBElement(_RequestIdentifierType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "PlaceOfPublication"
    )
    public JAXBElement<String> createPlaceOfPublication(String value) {
        return new JAXBElement(_PlaceOfPublication_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ItemDescriptionLevel"
    )
    public JAXBElement<SchemeValuePair> createItemDescriptionLevel(SchemeValuePair value) {
        return new JAXBElement(_ItemDescriptionLevel_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "CurrencyCode"
    )
    public JAXBElement<SchemeValuePair> createCurrencyCode(SchemeValuePair value) {
        return new JAXBElement(_CurrencyCode_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateReturned"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateReturned(XMLGregorianCalendar value) {
        return new JAXBElement(_DateReturned_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ProblemValue"
    )
    public JAXBElement<String> createProblemValue(String value) {
        return new JAXBElement(_ProblemValue_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ItemIdentifierType"
    )
    public JAXBElement<SchemeValuePair> createItemIdentifierType(SchemeValuePair value) {
        return new JAXBElement(_ItemIdentifierType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "SponsoringBody"
    )
    public JAXBElement<String> createSponsoringBody(String value) {
        return new JAXBElement(_SponsoringBody_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ToSystemId"
    )
    public JAXBElement<SchemeValuePair> createToSystemId(SchemeValuePair value) {
        return new JAXBElement(_ToSystemId_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateReceived"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateReceived(XMLGregorianCalendar value) {
        return new JAXBElement(_DateReceived_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "LocationNameLevel"
    )
    @XmlJavaTypeAdapter(Adapter2.class)
    public JAXBElement<BigDecimal> createLocationNameLevel(BigDecimal value) {
        return new JAXBElement(_LocationNameLevel_QNAME, BigDecimal.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "CareOf"
    )
    public JAXBElement<String> createCareOf(String value) {
        return new JAXBElement(_CareOf_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ShippingInstructions"
    )
    public JAXBElement<String> createShippingInstructions(String value) {
        return new JAXBElement(_ShippingInstructions_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ComponentIdentifier"
    )
    public JAXBElement<String> createComponentIdentifier(String value) {
        return new JAXBElement(_ComponentIdentifier_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "AuthenticationPromptType"
    )
    public JAXBElement<SchemeValuePair> createAuthenticationPromptType(SchemeValuePair value) {
        return new JAXBElement(_AuthenticationPromptType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "TitleOfComponent"
    )
    public JAXBElement<String> createTitleOfComponent(String value) {
        return new JAXBElement(_TitleOfComponent_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ValidFromDate"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createValidFromDate(XMLGregorianCalendar value) {
        return new JAXBElement(_ValidFromDate_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Country"
    )
    public JAXBElement<String> createCountry(String value) {
        return new JAXBElement(_Country_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Author"
    )
    public JAXBElement<String> createAuthor(String value) {
        return new JAXBElement(_Author_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "TitleHoldQueueLength"
    )
    @XmlJavaTypeAdapter(Adapter2.class)
    public JAXBElement<BigDecimal> createTitleHoldQueueLength(BigDecimal value) {
        return new JAXBElement(_TitleHoldQueueLength_QNAME, BigDecimal.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "UnstructuredHoldingsData"
    )
    public JAXBElement<String> createUnstructuredHoldingsData(String value) {
        return new JAXBElement(_UnstructuredHoldingsData_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "HoldPickupDate"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createHoldPickupDate(XMLGregorianCalendar value) {
        return new JAXBElement(_HoldPickupDate_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "MaximumItemsCount"
    )
    @XmlJavaTypeAdapter(Adapter2.class)
    public JAXBElement<BigDecimal> createMaximumItemsCount(BigDecimal value) {
        return new JAXBElement(_MaximumItemsCount_QNAME, BigDecimal.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "BibliographicItemIdentifier"
    )
    public JAXBElement<String> createBibliographicItemIdentifier(String value) {
        return new JAXBElement(_BibliographicItemIdentifier_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Suffix"
    )
    public JAXBElement<String> createSuffix(String value) {
        return new JAXBElement(_Suffix_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateSent"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateSent(XMLGregorianCalendar value) {
        return new JAXBElement(_DateSent_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "UnstructuredAddressData"
    )
    public JAXBElement<String> createUnstructuredAddressData(String value) {
        return new JAXBElement(_UnstructuredAddressData_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Edition"
    )
    public JAXBElement<String> createEdition(String value) {
        return new JAXBElement(_Edition_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "AuthorOfComponent"
    )
    public JAXBElement<String> createAuthorOfComponent(String value) {
        return new JAXBElement(_AuthorOfComponent_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "PickupDate"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createPickupDate(XMLGregorianCalendar value) {
        return new JAXBElement(_PickupDate_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Initials"
    )
    public JAXBElement<String> createInitials(String value) {
        return new JAXBElement(_Initials_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ReferenceToResource"
    )
    public JAXBElement<String> createReferenceToResource(String value) {
        return new JAXBElement(_ReferenceToResource_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DesiredDateForReturn"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDesiredDateForReturn(XMLGregorianCalendar value) {
        return new JAXBElement(_DesiredDateForReturn_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "UserIdentifierValue"
    )
    public JAXBElement<String> createUserIdentifierValue(String value) {
        return new JAXBElement(_UserIdentifierValue_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "PhysicalAddressType"
    )
    public JAXBElement<SchemeValuePair> createPhysicalAddressType(SchemeValuePair value) {
        return new JAXBElement(_PhysicalAddressType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "FiscalTransactionIdentifierValue"
    )
    public JAXBElement<String> createFiscalTransactionIdentifierValue(String value) {
        return new JAXBElement(_FiscalTransactionIdentifierValue_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "OrganizationNameType"
    )
    public JAXBElement<SchemeValuePair> createOrganizationNameType(SchemeValuePair value) {
        return new JAXBElement(_OrganizationNameType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "MediumType"
    )
    public JAXBElement<SchemeValuePair> createMediumType(SchemeValuePair value) {
        return new JAXBElement(_MediumType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ItemIdentifierValue"
    )
    public JAXBElement<String> createItemIdentifierValue(String value) {
        return new JAXBElement(_ItemIdentifierValue_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "FiscalActionType"
    )
    public JAXBElement<SchemeValuePair> createFiscalActionType(SchemeValuePair value) {
        return new JAXBElement(_FiscalActionType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "SeriesTitleNumber"
    )
    public JAXBElement<String> createSeriesTitleNumber(String value) {
        return new JAXBElement(_SeriesTitleNumber_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "CirculationStatus"
    )
    public JAXBElement<SchemeValuePair> createCirculationStatus(SchemeValuePair value) {
        return new JAXBElement(_CirculationStatus_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateOfBirth"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateOfBirth(XMLGregorianCalendar value) {
        return new JAXBElement(_DateOfBirth_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "RequiredItemUseRestrictionType"
    )
    public JAXBElement<SchemeValuePair> createRequiredItemUseRestrictionType(SchemeValuePair value) {
        return new JAXBElement(_RequiredItemUseRestrictionType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateShipped"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateShipped(XMLGregorianCalendar value) {
        return new JAXBElement(_DateShipped_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "EnumerationCaption"
    )
    public JAXBElement<String> createEnumerationCaption(String value) {
        return new JAXBElement(_EnumerationCaption_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DatePlaced"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDatePlaced(XMLGregorianCalendar value) {
        return new JAXBElement(_DatePlaced_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "EnumerationLevel"
    )
    @XmlJavaTypeAdapter(Adapter2.class)
    public JAXBElement<BigDecimal> createEnumerationLevel(BigDecimal value) {
        return new JAXBElement(_EnumerationLevel_QNAME, BigDecimal.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "HoldQueueLength"
    )
    @XmlJavaTypeAdapter(Adapter2.class)
    public JAXBElement<BigDecimal> createHoldQueueLength(BigDecimal value) {
        return new JAXBElement(_HoldQueueLength_QNAME, BigDecimal.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "UserPrivilegeStatusType"
    )
    public JAXBElement<SchemeValuePair> createUserPrivilegeStatusType(SchemeValuePair value) {
        return new JAXBElement(_UserPrivilegeStatusType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ProblemDetail"
    )
    public JAXBElement<String> createProblemDetail(String value) {
        return new JAXBElement(_ProblemDetail_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "RenewalCount"
    )
    @XmlJavaTypeAdapter(Adapter2.class)
    public JAXBElement<BigDecimal> createRenewalCount(BigDecimal value) {
        return new JAXBElement(_RenewalCount_QNAME, BigDecimal.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ElectronicAddressType"
    )
    public JAXBElement<SchemeValuePair> createElectronicAddressType(SchemeValuePair value) {
        return new JAXBElement(_ElectronicAddressType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "NumberOfPieces"
    )
    @XmlJavaTypeAdapter(Adapter2.class)
    public JAXBElement<BigDecimal> createNumberOfPieces(BigDecimal value) {
        return new JAXBElement(_NumberOfPieces_QNAME, BigDecimal.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ProblemElement"
    )
    public JAXBElement<String> createProblemElement(String value) {
        return new JAXBElement(_ProblemElement_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Prefix"
    )
    public JAXBElement<String> createPrefix(String value) {
        return new JAXBElement(_Prefix_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "BibliographicItemIdentifierCode"
    )
    public JAXBElement<SchemeValuePair> createBibliographicItemIdentifierCode(SchemeValuePair value) {
        return new JAXBElement(_BibliographicItemIdentifierCode_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "AgencyId"
    )
    public JAXBElement<SchemeValuePair> createAgencyId(SchemeValuePair value) {
        return new JAXBElement(_AgencyId_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "PickupExpiryDate"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createPickupExpiryDate(XMLGregorianCalendar value) {
        return new JAXBElement(_PickupExpiryDate_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "NeedBeforeDate"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createNeedBeforeDate(XMLGregorianCalendar value) {
        return new JAXBElement(_NeedBeforeDate_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "UserIdentifierType"
    )
    public JAXBElement<SchemeValuePair> createUserIdentifierType(SchemeValuePair value) {
        return new JAXBElement(_UserIdentifierType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "PublicationDateOfComponent"
    )
    public JAXBElement<String> createPublicationDateOfComponent(String value) {
        return new JAXBElement(_PublicationDateOfComponent_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateReportedReturned"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateReportedReturned(XMLGregorianCalendar value) {
        return new JAXBElement(_DateReportedReturned_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Surname"
    )
    public JAXBElement<String> createSurname(String value) {
        return new JAXBElement(_Surname_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "FromSystemAuthentication"
    )
    public JAXBElement<String> createFromSystemAuthentication(String value) {
        return new JAXBElement(_FromSystemAuthentication_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "NoticeType"
    )
    public JAXBElement<SchemeValuePair> createNoticeType(SchemeValuePair value) {
        return new JAXBElement(_NoticeType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateDue"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateDue(XMLGregorianCalendar value) {
        return new JAXBElement(_DateDue_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "PickupLocation"
    )
    public JAXBElement<SchemeValuePair> createPickupLocation(SchemeValuePair value) {
        return new JAXBElement(_PickupLocation_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "LocationWithinBuilding"
    )
    public JAXBElement<String> createLocationWithinBuilding(String value) {
        return new JAXBElement(_LocationWithinBuilding_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "AcknowledgedItemUseRestrictionType"
    )
    public JAXBElement<SchemeValuePair> createAcknowledgedItemUseRestrictionType(SchemeValuePair value) {
        return new JAXBElement(_AcknowledgedItemUseRestrictionType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Publisher"
    )
    public JAXBElement<String> createPublisher(String value) {
        return new JAXBElement(_Publisher_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "MonetaryValue"
    )
    @XmlJavaTypeAdapter(Adapter2.class)
    public JAXBElement<BigDecimal> createMonetaryValue(BigDecimal value) {
        return new JAXBElement(_MonetaryValue_QNAME, BigDecimal.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "CallNumber"
    )
    public JAXBElement<String> createCallNumber(String value) {
        return new JAXBElement(_CallNumber_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ComponentIdentifierType"
    )
    public JAXBElement<SchemeValuePair> createComponentIdentifierType(SchemeValuePair value) {
        return new JAXBElement(_ComponentIdentifierType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateForReturn"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateForReturn(XMLGregorianCalendar value) {
        return new JAXBElement(_DateForReturn_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "NextItemToken"
    )
    public JAXBElement<String> createNextItemToken(String value) {
        return new JAXBElement(_NextItemToken_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "FromSystemId"
    )
    public JAXBElement<SchemeValuePair> createFromSystemId(SchemeValuePair value) {
        return new JAXBElement(_FromSystemId_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ChronologyCaption"
    )
    public JAXBElement<String> createChronologyCaption(String value) {
        return new JAXBElement(_ChronologyCaption_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DesiredDateDue"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDesiredDateDue(XMLGregorianCalendar value) {
        return new JAXBElement(_DesiredDateDue_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ChronologyLevel"
    )
    @XmlJavaTypeAdapter(Adapter2.class)
    public JAXBElement<BigDecimal> createChronologyLevel(BigDecimal value) {
        return new JAXBElement(_ChronologyLevel_QNAME, BigDecimal.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "FiscalTransactionType"
    )
    public JAXBElement<SchemeValuePair> createFiscalTransactionType(SchemeValuePair value) {
        return new JAXBElement(_FiscalTransactionType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Pagination"
    )
    public JAXBElement<String> createPagination(String value) {
        return new JAXBElement(_Pagination_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "NoticeContent"
    )
    public JAXBElement<String> createNoticeContent(String value) {
        return new JAXBElement(_NoticeContent_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "RequestIdentifierValue"
    )
    public JAXBElement<String> createRequestIdentifierValue(String value) {
        return new JAXBElement(_RequestIdentifierValue_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "FiscalTransactionDescription"
    )
    public JAXBElement<String> createFiscalTransactionDescription(String value) {
        return new JAXBElement(_FiscalTransactionDescription_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "AuthenticationPromptData"
    )
    public JAXBElement<String> createAuthenticationPromptData(String value) {
        return new JAXBElement(_AuthenticationPromptData_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "GivenName"
    )
    public JAXBElement<String> createGivenName(String value) {
        return new JAXBElement(_GivenName_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "RequestedActionType"
    )
    public JAXBElement<SchemeValuePair> createRequestedActionType(SchemeValuePair value) {
        return new JAXBElement(_RequestedActionType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "UserPrivilegeDescription"
    )
    public JAXBElement<String> createUserPrivilegeDescription(String value) {
        return new JAXBElement(_UserPrivilegeDescription_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "RequestElementType"
    )
    public JAXBElement<SchemeValuePair> createRequestElementType(SchemeValuePair value) {
        return new JAXBElement(_RequestElementType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "RequestType"
    )
    public JAXBElement<SchemeValuePair> createRequestType(SchemeValuePair value) {
        return new JAXBElement(_RequestType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "District"
    )
    public JAXBElement<String> createDistrict(String value) {
        return new JAXBElement(_District_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "UserLanguage"
    )
    public JAXBElement<SchemeValuePair> createUserLanguage(SchemeValuePair value) {
        return new JAXBElement(_UserLanguage_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "BinNumber"
    )
    public JAXBElement<String> createBinNumber(String value) {
        return new JAXBElement(_BinNumber_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Region"
    )
    public JAXBElement<String> createRegion(String value) {
        return new JAXBElement(_Region_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ElectronicAddressData"
    )
    public JAXBElement<String> createElectronicAddressData(String value) {
        return new JAXBElement(_ElectronicAddressData_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "LoanedItemCountValue"
    )
    @XmlJavaTypeAdapter(Adapter2.class)
    public JAXBElement<BigDecimal> createLoanedItemCountValue(BigDecimal value) {
        return new JAXBElement(_LoanedItemCountValue_QNAME, BigDecimal.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "UserElementType"
    )
    public JAXBElement<SchemeValuePair> createUserElementType(SchemeValuePair value) {
        return new JAXBElement(_UserElementType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ReminderLevel"
    )
    @XmlJavaTypeAdapter(Adapter2.class)
    public JAXBElement<BigDecimal> createReminderLevel(BigDecimal value) {
        return new JAXBElement(_ReminderLevel_QNAME, BigDecimal.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "HoldingsSetId"
    )
    public JAXBElement<String> createHoldingsSetId(String value) {
        return new JAXBElement(_HoldingsSetId_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ConsortiumAgreement"
    )
    public JAXBElement<SchemeValuePair> createConsortiumAgreement(SchemeValuePair value) {
        return new JAXBElement(_ConsortiumAgreement_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "HoldQueuePosition"
    )
    @XmlJavaTypeAdapter(Adapter2.class)
    public JAXBElement<BigDecimal> createHoldQueuePosition(BigDecimal value) {
        return new JAXBElement(_HoldQueuePosition_QNAME, BigDecimal.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "LocationNameValue"
    )
    public JAXBElement<String> createLocationNameValue(String value) {
        return new JAXBElement(_LocationNameValue_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "BibliographicRecordIdentifierCode"
    )
    public JAXBElement<SchemeValuePair> createBibliographicRecordIdentifierCode(SchemeValuePair value) {
        return new JAXBElement(_BibliographicRecordIdentifierCode_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "HouseName"
    )
    public JAXBElement<String> createHouseName(String value) {
        return new JAXBElement(_HouseName_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "EarliestDateNeeded"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createEarliestDateNeeded(XMLGregorianCalendar value) {
        return new JAXBElement(_EarliestDateNeeded_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Locality"
    )
    public JAXBElement<String> createLocality(String value) {
        return new JAXBElement(_Locality_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "AuthenticationInputData"
    )
    public JAXBElement<String> createAuthenticationInputData(String value) {
        return new JAXBElement(_AuthenticationInputData_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ApplicationProfileSupportedType"
    )
    public JAXBElement<SchemeValuePair> createApplicationProfileSupportedType(SchemeValuePair value) {
        return new JAXBElement(_ApplicationProfileSupportedType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "AgencyUserPrivilegeType"
    )
    public JAXBElement<SchemeValuePair> createAgencyUserPrivilegeType(SchemeValuePair value) {
        return new JAXBElement(_AgencyUserPrivilegeType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ValidToDate"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createValidToDate(XMLGregorianCalendar value) {
        return new JAXBElement(_ValidToDate_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "PaymentMethodType"
    )
    public JAXBElement<SchemeValuePair> createPaymentMethodType(SchemeValuePair value) {
        return new JAXBElement(_PaymentMethodType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateOfExpectedReply"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateOfExpectedReply(XMLGregorianCalendar value) {
        return new JAXBElement(_DateOfExpectedReply_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "SecurityMarker"
    )
    public JAXBElement<SchemeValuePair> createSecurityMarker(SchemeValuePair value) {
        return new JAXBElement(_SecurityMarker_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "UserAddressRoleType"
    )
    public JAXBElement<SchemeValuePair> createUserAddressRoleType(SchemeValuePair value) {
        return new JAXBElement(_UserAddressRoleType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateEventOccurred"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateEventOccurred(XMLGregorianCalendar value) {
        return new JAXBElement(_DateEventOccurred_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "UnstructuredPersonalUserName"
    )
    public JAXBElement<String> createUnstructuredPersonalUserName(String value) {
        return new JAXBElement(_UnstructuredPersonalUserName_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "EnumerationValue"
    )
    public JAXBElement<String> createEnumerationValue(String value) {
        return new JAXBElement(_EnumerationValue_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "AccrualDate"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createAccrualDate(XMLGregorianCalendar value) {
        return new JAXBElement(_AccrualDate_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ItemElementType"
    )
    public JAXBElement<SchemeValuePair> createItemElementType(SchemeValuePair value) {
        return new JAXBElement(_ItemElementType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ApplicationProfileType"
    )
    public JAXBElement<SchemeValuePair> createApplicationProfileType(SchemeValuePair value) {
        return new JAXBElement(_ApplicationProfileType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Language"
    )
    public JAXBElement<SchemeValuePair> createLanguage(SchemeValuePair value) {
        return new JAXBElement(_Language_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "PostOfficeBox"
    )
    public JAXBElement<String> createPostOfficeBox(String value) {
        return new JAXBElement(_PostOfficeBox_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ChronologyValue"
    )
    public JAXBElement<String> createChronologyValue(String value) {
        return new JAXBElement(_ChronologyValue_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateRecalled"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateRecalled(XMLGregorianCalendar value) {
        return new JAXBElement(_DateRecalled_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "RequestedItemCountValue"
    )
    @XmlJavaTypeAdapter(Adapter2.class)
    public JAXBElement<BigDecimal> createRequestedItemCountValue(BigDecimal value) {
        return new JAXBElement(_RequestedItemCountValue_QNAME, BigDecimal.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "PostalCode"
    )
    public JAXBElement<String> createPostalCode(String value) {
        return new JAXBElement(_PostalCode_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "CopyNumber"
    )
    public JAXBElement<String> createCopyNumber(String value) {
        return new JAXBElement(_CopyNumber_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ItemNote"
    )
    public JAXBElement<String> createItemNote(String value) {
        return new JAXBElement(_ItemNote_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "OrganizationName"
    )
    public JAXBElement<String> createOrganizationName(String value) {
        return new JAXBElement(_OrganizationName_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Line2"
    )
    public JAXBElement<String> createLine2(String value) {
        return new JAXBElement(_Line2_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateRenewed"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateRenewed(XMLGregorianCalendar value) {
        return new JAXBElement(_DateRenewed_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Line1"
    )
    public JAXBElement<String> createLine1(String value) {
        return new JAXBElement(_Line1_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "RequestStatusType"
    )
    public JAXBElement<SchemeValuePair> createRequestStatusType(SchemeValuePair value) {
        return new JAXBElement(_RequestStatusType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateOfUserRequest"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateOfUserRequest(XMLGregorianCalendar value) {
        return new JAXBElement(_DateOfUserRequest_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "LocationType"
    )
    public JAXBElement<SchemeValuePair> createLocationType(SchemeValuePair value) {
        return new JAXBElement(_LocationType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ItemUseRestrictionType"
    )
    public JAXBElement<SchemeValuePair> createItemUseRestrictionType(SchemeValuePair value) {
        return new JAXBElement(_ItemUseRestrictionType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateOfUserPrivilegeStatus"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateOfUserPrivilegeStatus(XMLGregorianCalendar value) {
        return new JAXBElement(_DateOfUserPrivilegeStatus_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateToSend"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateToSend(XMLGregorianCalendar value) {
        return new JAXBElement(_DateToSend_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "BlockOrTrapType"
    )
    public JAXBElement<SchemeValuePair> createBlockOrTrapType(SchemeValuePair value) {
        return new JAXBElement(_BlockOrTrapType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ProblemType"
    )
    public JAXBElement<SchemeValuePair> createProblemType(SchemeValuePair value) {
        return new JAXBElement(_ProblemType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "AgencyAddressRoleType"
    )
    public JAXBElement<SchemeValuePair> createAgencyAddressRoleType(SchemeValuePair value) {
        return new JAXBElement(_AgencyAddressRoleType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "DateAvailable"
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    public JAXBElement<XMLGregorianCalendar> createDateAvailable(XMLGregorianCalendar value) {
        return new JAXBElement(_DateAvailable_QNAME, XMLGregorianCalendar.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "AuthenticationInputType"
    )
    public JAXBElement<SchemeValuePair> createAuthenticationInputType(SchemeValuePair value) {
        return new JAXBElement(_AuthenticationInputType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "PhysicalConditionType"
    )
    public JAXBElement<SchemeValuePair> createPhysicalConditionType(SchemeValuePair value) {
        return new JAXBElement(_PhysicalConditionType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ShippingNote"
    )
    public JAXBElement<String> createShippingNote(String value) {
        return new JAXBElement(_ShippingNote_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "Title"
    )
    public JAXBElement<String> createTitle(String value) {
        return new JAXBElement(_Title_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "RoutingInstructions"
    )
    public JAXBElement<String> createRoutingInstructions(String value) {
        return new JAXBElement(_RoutingInstructions_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "UnstructuredAddressType"
    )
    public JAXBElement<SchemeValuePair> createUnstructuredAddressType(SchemeValuePair value) {
        return new JAXBElement(_UnstructuredAddressType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "RequestScopeType"
    )
    public JAXBElement<SchemeValuePair> createRequestScopeType(SchemeValuePair value) {
        return new JAXBElement(_RequestScopeType_QNAME, SchemeValuePair.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ActualResource"
    )
    public JAXBElement<String> createActualResource(String value) {
        return new JAXBElement(_ActualResource_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "UserElementEnum"
    )
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createUserElementEnum(String value) {
        return new JAXBElement(_UserElementEnum_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "PublicationDate"
    )
    public JAXBElement<String> createPublicationDate(String value) {
        return new JAXBElement(_PublicationDate_QNAME, String.class, (Class)null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.niso.org/2008/ncip",
            name = "ElectronicDataFormatType"
    )
    public JAXBElement<SchemeValuePair> createElectronicDataFormatType(SchemeValuePair value) {
        return new JAXBElement(_ElectronicDataFormatType_QNAME, SchemeValuePair.class, (Class)null, value);
    }
}
